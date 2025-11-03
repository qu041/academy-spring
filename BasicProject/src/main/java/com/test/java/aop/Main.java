package com.test.java.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 
		 	AOP, Aspect Oriented Programming
		 	- 관점 지향 프로그래밍
		 	- 주업무 + 보조업무 > 같은 파일에 작성하는 경우가 흔하다.
		 					   > 코드 관리 불편, 가독성 저하, 중복 코드 발생
		  	
		  	- 주업무 + 보조업무 > 완전한 분리
		  					   > 코드 관리 용이, 가독성 향상, 중복 코드 제거
		  
		 */
		
		//메모장 구현
		
		//m1();
		//m2();
		m3();
}
	private static void m3() {
		//Memo memo = new MemoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/java/aop/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");
		
		//주업무만 존재
		memo.add("메모입니다");
		
		try {
			String content = memo.read("1");
			System.out.println("메모읽기:" +content);
		} catch (Exception e) {
			e.printStackTrace();
	}
		System.out.println(memo.edit("1", "수정된 메모"));
		System.out.println(memo.del("1"));
	}

	private static void m2() {
		
		//개발자 입장
		
		Logger logger = new Logger();
		Memo memo = new MemoImpl();
		
		memo.add("메모입니다");
		logger.log();
		try {
			String content = memo.read("1");
			System.out.println("메모읽기:" +content);
			logger.log();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(memo.edit("1", "수정된 메모"));
		logger.log();
		
		System.out.println(memo.del("1"));
		logger.log();
	}
	
	private static void m1() {
		Memo memo = new MemoImpl();
		
		memo.add("메모입니다");
		
		try {
			String content = memo.read("1");
			System.out.println("메모읽기:" +content);
		} catch (Exception e) {
			e.printStackTrace();
	}
		System.out.println(memo.edit("1", "수정된 메모"));
		System.out.println(memo.del("1"));
	}
}
