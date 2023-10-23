package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.Models.User;
import com.test.repo.UserRepository;

@SpringBootApplication
public class SpringSecurity2Application implements CommandLineRunner{
	@Autowired
   private UserRepository repository;
	@Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u = new User();
		u.setEmail("furqan@khan");
		u.setPassword(this.bCryptPasswordEncoder.encode("12345"));
		u.setRole("ROLE_ADMIN");
		u.setUsername("faiz");
		u.setId(9);
		User save = this.repository.save(u);
		
	}

}
