package com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.Models.CustomUserDetail;
import com.test.Models.User;
import com.test.repo.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
   private UserRepository repository;
	
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.repository.findByUsername(username);
		if(user ==null) {
			throw new UsernameNotFoundException("no user");
		}
		return new CustomUserDetail(user);
	}

}
