package com.test.java.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit + Spring
//JUnit4 > 생성자 의존 주입을 지원하지 않는다. > 필드 주입
//JUnit5 > 생성자 의존 주입을 지원함 > 생성자 의존 주입
@RunWith(SpringJUnit4ClassRunner.class) //무지성으로 어노테이션 걸어야됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommonsDBCPTests {
		
	//테스트 파일 > 실행 방법
	//1. Ctrl + F11
	// - 파일 내의 모든 @Test 메서드 실행
	//2. @Ignore
	// - 일부 테스트 무시
	//3. 메서드 헤더 > Run as
	// - 원하는 특정 메서드 테스트 실행
	
	@Autowired
	private DataSource dataSource;
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	public void testXXX() {
		
	}
	
	@Ignore
	@Test
	public void testGetDataSource() {
		
		//System.out.println(dataSource != null);
		
		assertNotNull(dataSource);
		
	}
	
	@Test
	public void testCreateConnection() {
		
		Connection conn = null;
		
		try {
			
			conn = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertNotNull(conn);
		
	}
	
	@Test
	public void testIsConnection() {
		
		Connection conn = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			assertFalse(conn.isClosed());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
