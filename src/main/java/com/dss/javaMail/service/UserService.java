package com.dss.javaMail.service;

import java.util.List;

import com.dss.javaMail.entity.User;

public interface UserService {

	List<User> getUser();

	void registerUser(User user);

	User getUserByCode(User user);

	void updateState(User user);
	
}
