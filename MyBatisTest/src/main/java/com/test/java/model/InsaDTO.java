package com.test.java.model;

import java.util.List;

import lombok.Data;

@Data
public class InsaDTO {
	
	private String num;
	private String name;
	private String buseo;
	private String jikwi;
	private Integer salary;
	
	private List<ProjectDTO> project;
	
}
