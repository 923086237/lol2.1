package com.ssm.dao;

import com.ssm.entity.User;

public interface UserMapper {
	public User findByName(String name);
	
	public void addUser(User user);
	
	public void updateUser(User user);
}
