package com.test.project.mapper;

import com.test.project.model.UserDTO;

public interface MemberMapper {

	UserDTO get(String username);
	
	
	void add(UserDTO dto);

}
