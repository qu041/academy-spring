package com.test.java.di03;

public class Service {
	
	//1. DI 패턴 > 의존 객체를 담을 멤버 변수를 선언한다.
	private Employee employee;
	
	
	
	public Service (Employee employee) {
		this.employee = employee;
	}
	
	public void doSomething() {
		
		System.out.println("자료 취합");
		
		//lee.work();
		employee.work();
		
		
		System.out.println("자료 전송");
		
	}

}
