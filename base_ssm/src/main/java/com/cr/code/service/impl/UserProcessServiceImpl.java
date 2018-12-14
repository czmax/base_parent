package com.max.code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.code.dao.UserMapper;
import com.max.code.entity.User;
import com.max.code.service.UserProcessService;

@Service
public class UserProcessServiceImpl implements UserProcessService {

	@Autowired
	private UserMapper userDao;

	public boolean login(User userParam) {

		User user = userDao.getUserById(userParam.getId());
		boolean loginSuccess = user == null ? false : true;
		return loginSuccess;
	}

}
