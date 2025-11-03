package com.test.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //무지성으로 어노테이션 걸어야됨(스프링테스트용)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBTests {

	@Autowired
	private SqlSessionTemplate template;
	
	@Test
	public void test() {
		
		assertNotNull(template);
		
		String time = template.selectOne("rest.time");
		
		System.out.println(time);
	}
	
	
	
	

}
