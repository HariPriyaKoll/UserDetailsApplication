package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/getAllUsers",produces = "application/json")
	public String getAllUsers() {
		logger.info("Getting all users.");
		return userService.getUserDetails();
	}
}
