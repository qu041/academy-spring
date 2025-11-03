package com.test.java.model;

import lombok.Data;

@Data
public class AddressDTO {
	
	private String seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	//- 1(tblAddress) : 1(tblPoint) 1대1관계
	private PointDTO pdto;
	

}
