package com.test.java.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class) //무지성으로 어노테이션 걸어야됨(스프링테스트용)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								"file:src/main/webapp/WEB-INF/spring/security-context.xml"
}) //지금 우리가 만든 bean태그 참조용
public class AddMember {
	
	//의존주입의 타입 > 인터페이스 + 상속 구현한 클래스가 2개 이상
	//1.@Qualifier 사용
	//or 2. 딱 1개 클래스만 구현, 나머지는 삭제
	@Autowired
	private SecurityMapper mapper;
	
	@Autowired
	//@Qualifier("bCryptPasswordEncoder")
	private PasswordEncoder encoder;

	@Test
	public void testEncoder() {
		
		assertNotNull(encoder);
		
		//$2a$10$J50zJc7taAX5cUqULpy6neno1l9A28kcuaDGZ6o3qupT3QZQYymzq
		String pw = "1111";
		System.out.println(encoder.encode(pw));
	}
		
	@Test
		public void add() {
			
			assertNotNull(mapper);
			MemberDTO dto = new MemberDTO();
			
			dto.setMemberid("dog");
			dto.setMemberpw(encoder.encode("1111"));
			dto.setMembername("강아지");
			dto.setEmail("dog@gmail.com");
			dto.setGender("m");
			
			mapper.add(dto);
			
			
		}
	@Test
    public void add2() {


        MemberDTO dto = new MemberDTO();

        dto.setMemberid("cat");
        dto.setMemberpw(encoder.encode("1111"));
        dto.setMembername("고양이");
        dto.setEmail("cat@gmail.com");
        dto.setGender("f");

        mapper.add(dto);
    }

    @Test
    public void add3() {


        MemberDTO dto = new MemberDTO();

        dto.setMemberid("tiger");
        dto.setMemberpw(encoder.encode("1111"));
        dto.setMembername("호랑이");
        dto.setEmail("tiger@gmail.com");
        dto.setGender("m");

        mapper.add(dto);
    }


}
