package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/ex04get.do", method = RequestMethod.GET)
public class Ex04GetController {
	
	@RequestMapping
	public String ex04get() {
		
		return "ex04get";
		
	}
}
