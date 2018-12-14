package com.max.code.dao;

import org.springframework.stereotype.Repository;

import com.max.code.entity.User;



@Repository
public interface UserMapper {
	
	public User getUserById(int id);

}
