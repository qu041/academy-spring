package com.test.java.model;

import lombok.Data;

@Data
public class AddressDTO {
	
	private String name;
	private Integer age; //나이 확보 실패시를 대비해서 Integer로 받음 not int
	private String address;

}
