package com.test.project.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.project.mapper.MemberMapper;
import com.test.project.model.UserDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final PasswordEncoder encoder;
	private final MemberMapper mapper;

	@GetMapping("/member/add")
	public String add() {
		
		return "member.add";
		
	}
	
	@PostMapping("/member/addok")
	public String addok(UserDTO dto) {
		
		//System.out.println(dto);
		//암호 > 암호화
		
		dto.setPw(encoder.encode(dto.getPw()));
		
		mapper.add(dto);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/member/login")
	public String login() {
		
		return "member.login";
		
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		
		return "member.logout";
		
	}
	
	
	
	
	
}





