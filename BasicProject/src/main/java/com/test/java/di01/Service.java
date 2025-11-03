package com.test.java.di01;

public class Service {
	
	//1. DI 패턴 > 의존 객체를 담을 멤버 변수를 선언한다.
	private Hong hong;
	private Lee lee;
	
	//2. DI 패턴 > 의존 객체를 주입받는다.
	// 		   	 > 의존 주입 도구를 선언한다. (생성자(대세) or setter)
	
	public Service (Hong hong) {
		this.hong = hong;
	}
	
	public Service (Lee lee) {
		this.lee = lee;
	}
	
	//public void setHong(Hong hong) {
	//	this.hong = hong;
	//}
	
	public void doSomething() {
		
		//Di, Dependency Injection
		//- 의존(성) 주입
		//- 디자인 패턴
		//- 객체가 필요로하는 의존성을 외부에서 주입해주는 패턴
		
		
		// Service 자신의 업무
		System.out.println("자료 취합");
		
		//일부 업무 > Hong 호출
		//Hong hong = new Hong();
		//hong.work();
		
		//Lee lee = new Lee();
		//lee.work();
		
		//의존 객체를 스스로 만드는 방식
		//Hong hong = new Hong();
		//hong.work();
		
		
		//hong.work();
		lee.work();
		
		
		System.out.println("자료 전송");
		
	}

}
