package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.entity.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao dao;

	@Override
	public User Login(String email, String password) {
		return dao.findByEmailAndPassword(email, password);
	}

	@Override
	public User createUser(User newUser) {
		return dao.save(newUser);
	}
}
