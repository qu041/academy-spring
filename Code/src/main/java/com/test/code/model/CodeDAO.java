package com.test.code.model;

import java.util.List;

public interface CodeDAO {
	
	//카테고리 + select
	List<LanguageDTO> llist();
	
	//코드게시판 + 글쓰기
	int add(CodeDTO dto);
	
	//코드게시판 + 목록보기
	List<CodeDTO> list();
	
	//코드게시판 + 상세보기
	CodeDTO get(String seq);
	
}
