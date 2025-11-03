package com.test.code.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CodeDAOImpl implements CodeDAO {
	
	private final SqlSessionTemplate template;
	
	@Override
	public List<LanguageDTO> llist() {
		// TODO Auto-generated method stub
		return template.selectList("code.llist");
	}
	
	@Override
	public int add(CodeDTO dto) {
		// TODO Auto-generated method stub
		return template.insert("code.add", dto);
	}
	
	
	@Override
	public List<CodeDTO> list() {
		// TODO Auto-generated method stub
		return template.selectList("code.list");
	}

	@Override
	public CodeDTO get(String seq) {
		// TODO Auto-generated method stub
		return template.selectOne("code.get",seq);
	}
	
}
