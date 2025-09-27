package com.example.SecurityExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SecurityExample.model.UserPrincipal;
import com.example.SecurityExample.model.Users;
import com.example.SecurityExample.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     Users users =userRepository.findByUsername(username);
	     if (users==null) {
			System.out.println("User NOT FOUND");
			throw new UsernameNotFoundException("User NOT FOUND");
		}
	     
		return new UserPrincipal(users);
	}

	
}
