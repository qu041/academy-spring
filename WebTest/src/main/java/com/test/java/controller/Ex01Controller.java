package com.test.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//스프링 > 서블릿을 사용 안함
//		 > 일반 클래스를 사용함

//이전의 서블릿 역할*(컨트롤러)
//컨트롤러?
//-전체적인 업무  흐름 통제
//- 클라이언트 요청 처리

//스프링 빈  
public class Ex01Controller implements Controller {
	
	
	//요청메서드
	//-doGet(), doPost() == handleRequest()
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//업무 진행..
		
		//RequestDispatcher > forward(req,resp) > JSP 호출
		
		//ModelAndView
		//1. Model 역할 > 데이터 전송 상자(request 역할)
		//2. View 역할 > JSP
		
		String name = "아무개";
		//request.setAttribute("name", name);
		
		ModelAndView mv = new ModelAndView();
		
		//mv.setViewName("JSP 경로");
		// /WEB-INF/views/WEB-INF/views/ex01.jsp.jsp
		mv.setViewName("ex01");
		mv.addObject("name",name);
		
		return mv;
	}
	
	
	

}
