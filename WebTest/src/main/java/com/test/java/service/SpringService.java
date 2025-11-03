package com.test.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.java.model.SpringDAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Component
@Service
//@NoArgsConstructor //default constructor > 인자값이 없는 기본 생성자
//@AllArgsConstructor //모든 멤버 변수를 인수로 가지는 생성자
@RequiredArgsConstructor //반드시 초기화가 필요한 멤버 변수(final 생성자만)
public class SpringService {
	
	//1.멤버변수 > 얘도 빈으로 바꿔줘야됨
//	//1. @Autowired + 생성자
//	private SpringDAO dao;
//	//2.생성자 or세터
//	//의존 주입 도구 > @Autowired 선언
//	//- Spring 2.5 부터 어노테이션 방식으로 바뀌기 시작함.
//	@Autowired //의존주입
//	public SpringService(SpringDAO dao) {
//		this.dao = dao;
//	}
	
//	//2. @Autowired + Setter
//		private SpringDAO dao;
//		
//		@Autowired
//		public void setDao(SpringDAO dao) {
//			this.dao = dao;
//		}
	
	
//		//3. @Autowired + 생성자/세터 안만듬 > 멤버변수에 바로 붙임
//		//- 테스트와 유지보수가 어렵다.
//		@Autowired
//		private SpringDAO dao;
		
		
		//4.생성자 + @Autowired 생략
		//- Spring 4.3부터 지원
		//- 생성자가 딱 1개일때만 지원
		//- 스프링이 객체를 생성할때 > 생성자 1개밖에 > 자동으로 @Autowired를 적용한다.
//		private SpringDAO dao;
//		
//		
//		public SpringService(SpringDAO dao) {
//			this.dao = dao;
//		}
	
		//5. Lombok 사용 + Setter
		//- lombok에게 나 대신 setter를 만들게 한다.
		//의존주입 도구를 롬복을 통해서 생성한다.
		
//		@Setter(onMethod_ = @Autowired)
//		private SpringDAO dao;
	
		//6. Lombok + 생성자 사용 (가장 많이 쓰는방법) > 1번이랑 똑같은 방법
		
		private final SpringDAO dao; //required
		private int num;			//optional
		private String name;
		
		
		
	
	
	
	
	
	/*
	 	스프링 빈을 만드는 방법
	 	1. XML
	 		- <bean class ="">
	 		
	 	2. 어노테이션(Annotation) _총 네종류
	 		- @Component > 그냥 빈 부여
	 		- @Controller > 역할 부여 > 컨트롤러 역할 + //가독성 UP
	 		- @Service	> 역할 부여 > 서비스 역할 +
	 		- @Repository > 역할 부여 > 저장소(DAO) 역할 + 
	 
	 
	 
	 */
	
	public String work() {
		
		//SpringDAO dao = new SpringDAO(); > 의존주입으로 바꿀거임
		
		String data = dao.work();
		
		
		return data;
	}

}
