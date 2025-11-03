package com.test.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.java.service.SpringService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Ex08Controller {
	
	private final SpringService service;
	
//	@Autowired //>의존주입
//	public Ex08Controller(SpringService service) {
//		this.service = service;
//	}

	
	@GetMapping("/ex08.do")
	public String ex08(Model model) {
		
		//Controller > (의존) > Service > (의존) > DAO
		//SpringService service = new SpringService();  > 서비스 객체도 스프링이 만듬

		String data = service.work();
		
		model.addAttribute("data",data);
		
		return "ex08";
		
	}
	
}
