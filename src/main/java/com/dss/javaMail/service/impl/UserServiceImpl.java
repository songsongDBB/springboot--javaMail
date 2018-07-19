package com.dss.javaMail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.javaMail.entity.User;
import com.dss.javaMail.mapper.UserMapper;
import com.dss.javaMail.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getUser() {
		return userMapper.getUser();
	}

	@Override
	public void registerUser(User user) {
		userMapper.registerUser(user);
	}

	@Override
	public User getUserByCode(User user) {
		return userMapper.getUserByCode(user);
	}

	@Override
	public void updateState(User user) {
		userMapper.updateState(user);
	}

}
