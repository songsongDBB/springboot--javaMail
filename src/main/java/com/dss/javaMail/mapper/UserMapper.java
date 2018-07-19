package com.dss.javaMail.mapper;

import java.util.List;

import com.dss.javaMail.entity.User;

public interface UserMapper {

	List<User> getUser();

	void registerUser(User user);

	User getUserByCode(User user);

	void updateState(User user);
	
}
