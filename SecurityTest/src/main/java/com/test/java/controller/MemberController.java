package com.test.java.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.model.AuthDTO;
import com.test.java.model.MemberDTO;
import com.test.java.model.MemberMapper;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberMapper mapper;
	private final BCryptPasswordEncoder encoder;
	
	
	@GetMapping("/register.do")
	public String register() {
		return "register";
	}
	
	@PostMapping("/registerok.do")
	public String registerok(MemberDTO dto, String auth) {
		
		//403 발생 원인
		//1. 권한 부족
		//2. POST 전송시 CSRF 토큰을 안 보냈을 때 > jsp 파일에서 토큰 보내기
		//2.1 비밀번호 암호화 없이 저장할 때 > 사용자가 입력한 암호를 암호화를 시킨 뒤 암호화 진행
		
		//회원 정보 insert 관련
		dto.setMemberpw(encoder.encode(dto.getMemberpw()));
		mapper.add(dto);
		
		//회원 권한 추가
		//1. 일반회원 > ROLE_MEMBER
		//2. 관리자 > ROLE_MEMBER + ROLE_ADMIN
		
		if (auth.equals("1") || auth.equals("2")) {
			//권한 + 누구?
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_MEMBER");
			mapper.addAuth(adto);
		}
		
		if (auth.equals("2")) {
			//권한 + 누구?
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_ADMIN");
			mapper.addAuth(adto);
		}
		
		
		return "registerok";
		
		
	}
	
	
	
	
	
}
