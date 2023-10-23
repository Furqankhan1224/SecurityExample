package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.test.Models.User;

public interface UserRepository extends JpaRepository<User, String>{
public User findByUsername(String username);
}
