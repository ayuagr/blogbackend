package com.app.service;

import com.app.entity.User;

public interface IUserService {
	
	public User Login(String email,String password);

	public User createUser(User newUser);
}
