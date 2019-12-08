package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
   
	@Autowired
	UserDao userDao;
	
	@Override
	public String getUserDetails() {
		String userData= userDao.getUserDetails();
		return userData;
	}

}
