package com.test.code.model;

import lombok.Data;

@Data
public class CodeDTO {
	
	private String seq;
	private String subject;
	private String code;
	private String regdate;
	private String language;
	
	//1:1 <associate>
    //1:N <collection>
	private LanguageDTO ldto;

}
