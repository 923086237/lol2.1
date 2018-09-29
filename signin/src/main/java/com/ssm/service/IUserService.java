package com.ssm.service;

import com.ssm.entity.User;

public interface IUserService {
	public User findByName(String name);
	
	public void addUser(User user);
	
	public void updateUser(User user);
}
