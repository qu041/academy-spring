package com.test.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.java.model.AddressDTO;

@Controller	
public class Ex07Controller {

	//요청 메서드의 반환값 종류
	
	//1. String
	//- JSP 파일명
	//- ViewResolver 호출
//	@GetMapping(value = "/ex07.do")
//	public String ex07() {
//		
//		return "ex07";
//	}
	
	//2. void
	//- Spring 4.3 이후 지원
	//- 요청 주소의 이름과 동일한 JSP 호출한다.
//	@GetMapping(value = "/ex07.do")
//	public void ex07() {
//		
//		//ex07.jsp를 자동으로 호출한다.
//		
//	}
	
	
	//3. String + 키워드
	//- redirect > resp.sendRedirect() 역할
	//- forward  > pageContext.forward() 역할
//	@GetMapping(value = "/ex07.do")
//	public String ex07() {
//		
//		//return "redirect:/board/ex06.do";
//		return "forward:/board/ex06.do";
//	}
	
	//4. String
	//- RedirectAttributes
//	@GetMapping(value = "/ex07.do")
//	public String ex07(RedirectAttributes rttr) {
//		
//		String column = "subject";
//		String word = "java";
//		
//		rttr.addAttribute("column", column);
//		rttr.addAttribute("word", word);
//		
//		//return "redirect:/board/ex06.do?column=subject&word=java";
//		//return "redirect:/board/ex06.do?column=" + column +  "&word=" + word;
//		
//		//http://localhost:8080/java/board/ex06.do?column=subject&word=java
//		return "redirect:/board/ex06.do";
//	}
	
	
	//5. JSON 반환
	//- @ResponseBody + jackson-databind
	//- 요청 메서드의 반환값이 자동으로 JSON 변환 + 반환
//	@GetMapping(value = "/ex07.do")
//	public @ResponseBody String ex07() {
//		
//		/*
//			{
//				name: "홍길동"
//			}
//		*/
//		
//		String name = "hong";
//		
//		return name;
//	}
	
//	@GetMapping(value = "/ex07.do")
//	public @ResponseBody AddressDTO ex07() {
//		
//		//DB > select
//		AddressDTO dto = new AddressDTO();
//		dto.setName("홍길동");
//		dto.setAge(20);
//		dto.setAddress("서울시 강남구 대치동");
//		
//		return dto;
//	}
	
	@GetMapping(value = "/ex07.do")
	public @ResponseBody List<AddressDTO> ex07() {
		
		//DB > select
		AddressDTO dto = new AddressDTO();
		dto.setName("홍길동");
		dto.setAge(20);
		dto.setAddress("서울시 강남구 대치동");
		
		AddressDTO dto2 = new AddressDTO();
		dto2.setName("강아지");
		dto2.setAge(20);
		dto2.setAddress("서울시 강남구 대치동");
		
		AddressDTO dto3 = new AddressDTO();
		dto3.setName("고양이");
		dto3.setAge(20);
		dto3.setAddress("서울시 강남구 대치동");
		
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		list.add(dto);
		list.add(dto2);
		list.add(dto3);
		
		return list;
	}
	
}



































