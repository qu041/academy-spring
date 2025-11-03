package com.test.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.java.model.SpringDAO;

public class Ex02Controller implements Controller {
	//의존주입1
	///1.멤버변수 선언
	private SpringDAO dao;
	
	//2. 의존 주입 도구 생성(생성자 or 세터)
	
	 public Ex02Controller(SpringDAO dao) {
		 this.dao = dao;
	 }

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DB 작업
		
		//Ex02Controller <- (관계) -> SpringDAO
		//SpringDAO dao = new SpringDAO();
		
		//의존주입으로 바꿈
		
		int count = dao.count();
		
		
		
		ModelAndView mv = new ModelAndView("ex02");
		
		mv.addObject("count",count);
		
		return mv;
	}
	

}
