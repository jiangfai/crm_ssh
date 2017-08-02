package com.qfedu.mybatis1703.mapper;

import com.qfedu.mybatis1703.domain.User;

public interface UserMapper {
	
	User findByUsername(String username);
	
	void save(User user);
}
