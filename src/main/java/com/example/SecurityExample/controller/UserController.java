package com.example.SecurityExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityExample.model.Users;
import com.example.SecurityExample.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users users) {
		return userService.register(users);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users users) {
		return userService.verify(users);
	}
}
