package com.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.Models.User;

@Service
public class UserService {
	List<User> list =new ArrayList<>();
	public UserService() {
		list.add(new User(0, "furqan","123","furan34@gmail.com", null));
		list.add(new User(0, "abc","765","abc34@gmail.com", null));
		
	}
	public List<User> getAll(){
		return this.list;
	}
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	} 
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}

}
