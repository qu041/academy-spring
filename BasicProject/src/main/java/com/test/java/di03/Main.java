package com.test.java.di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		/*
		 	
		 	스프링 설정 방식
		 	1. XML 방식
		 	2. 어노테이션 방식
		 	3. 자바 방식

		 	Bean, 빈(객체)
		 	- 자바 빈
		 	- EJB > 객체를 빈이라고 표현
		 	- 스프링 >  객체를 빈이라고 표현
		 	
		 	스프링 역할 > 컨테이너 역할 
		 	1. 객체 생성(new Hong())
		 	2. 객체 관리
		 	3. 객체 소멸
		 	
		 	
		 	객체 생성 > 스프링에게 부탁
		 	1. XML > bean 정의(선언)
		 	2. 스프링 컨테이너 생성
		 	3. 빈 생성
		 */
		
		//직접 생성
		Hong hong1 = new Hong();
		
		//스프링을 통해서 생성
		
		//스프링 컨테이너 = 00 컨텍스트
		//ApplicationContext content = new ClassPathXmlApplicationContext("/src/main/java/com/test/java/di03/di03.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/java/di03/di03.xml");
		
		//new Hong() 호출
		Hong hong2 = (Hong)context.getBean("hong");
		
		//객체를 생성하는 방식이 차이가 있을 뿐
		//객체 자체는 차이가 전혀 없다.
		hong1.work();
		hong2.work();
		
		System.out.println(hong1.hashCode());
		System.out.println(hong2.hashCode());
		//System.out.println(lee.hashCode());
		
		Lee lee = (Lee)context.getBean("lee");
		lee.work();
		
		
		
	}
	
}
