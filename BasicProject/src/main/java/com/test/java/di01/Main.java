package com.test.java.di01;

public class Main {
	
	public static void main(String[] args) {
		
		// 조직
		// Main(사장) > Service(팀장) > Hong(팀원)
		
		// 객체 생성 순서
		//1. Hong
		//2. Service
		//3. Main
		
		//Main > (위임) >Service >(위임) > Hong
		//Main > (의존) >Service >(의존) > Hong
		
		//Hong > 퇴사 >
		//Lee > 입사 > 
		//- Hong와 Lee은 사람으로서는 다른 사람
		//- Hong와 Lee은 직원으로서는 같은 역할을 하는 직원
		
		//*** 여태까지의 방식
		//- 필요로하는 의존 객체를 직접 생성 + 생성하는 방식
		
		//*** 이후의 방식
		//- 의존 객체를 스스로 생성 안 함.
		//- 외부로부터 의존 객체를 주입받아 + 사용하는 방식
		
		System.out.println("사장이 할 일 함");
		
		//Service service = new Service();
		//service.doSomething();
		
		//Service가 의존하는 객체 > Main은 의존 안함 > 한다리 건너면 의존아님
		Hong hong = new Hong();
		
		//Service 생성 + 의존 객체 주입
		//Service service = new Service(hong); //의존 주입(DI)
		//service.doSomething();
		
		//Service service =  new Service();
		//service.setHong(hong); //의존 주입(DI) 발생
		//service.doSomething();
		
		//Service service = new Service(hong); //의존 주입(DI)
		//service.doSomething();
		
		Lee lee = new Lee();
		
		Service service = new Service(lee); //의존 주입(DI)
		service.doSomething();

	
	}
	
}
