package com.test.code.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) //무지성으로 어노테이션 걸어야됨(스프링테스트용)
@WebAppConfiguration
@ContextConfiguration(
		{
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		}
		)
public class CodeDAOImplTests {
	
	@Autowired
	private CodeDAO dao;
	
	@Test
	public void testCreateCodeDAO() {
			
		assertNotNull(dao);
	}

	@Test
	public void testListLanguage() {
		
		List<LanguageDTO> llist = dao.llist();
		System.out.println(llist);
		assertEquals(5, llist.size());
	}
	
	@Test
	public void testAddCode() {
		
		CodeDTO dto = new CodeDTO();
		dto.setSubject("샘플코드입니다.");
		dto.setCode("int a=10;");
		dto.setLanguage("Java");
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void testListCode() {
		
		List<CodeDTO> list = dao.list();
		
		System.out.println(list);
		
		assertEquals(1, list.size());
		
	}
	
	@Test
	public void testGetView() {
		
		CodeDTO dto = dao.get("2");
		
		assertNotNull(dto);
		
		assertEquals("샘플코드입니다.", dto.getSubject());
		
	}
	
}
