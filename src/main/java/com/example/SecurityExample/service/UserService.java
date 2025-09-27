package com.example.SecurityExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SecurityExample.model.Users;
import com.example.SecurityExample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;

	public Users register(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		return userRepository.save(users);
	}

	public String verify(Users users) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(users.getUsername());
		}
		return "Fail";
	}
}
