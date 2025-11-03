package com.test.mybatis.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.mybatis.mapper.AddressMapper;

import lombok.RequiredArgsConstructor;

//@Repository
//@RequiredArgsConstructor
//public class AddressDAO {
//	
//	//이전 방식
//	private final SqlSessionTemplate template;
//	
//}

@Repository
@RequiredArgsConstructor
public class AddressDAO {
	
	//현재 방식 > AddressMapper 인터페이스 매퍼
	private final AddressMapper mapper; //익명 객체 주입(스프링이 인터페이스의 자식객체를 알아서 만듬) 

	public List<AddressDTO> list() {
		
		return mapper.list();
	}
	
	
	public AddressDTO get(String seq) {
		return mapper.get(seq);
	}
	
	
}
