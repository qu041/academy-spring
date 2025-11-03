package com.test.java.model;

import org.springframework.stereotype.Repository;

@Repository
public class SpringDAO {

	public int count() {

		//select count(*) from tbl;
		
		return 100;
	}

	public void add(AddressDTO dto) {

		System.out.println(dto);
		
	}

	public String work() {
		
		//select..
		
		
		return "S스프링";
	}

}
