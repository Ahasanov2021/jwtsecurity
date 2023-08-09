package com.example.jwtsecurity;

import com.example.jwtsecurity.domain.Role;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtsecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "john@gmail.com", "john", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "henry@gmail.com", "henry", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "adolf@gmail.com", "adolf", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "putin@gmail.com", "putin", "password", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("henry", "ROLE_MANAGER");
			userService.addRoleToUser("adolf", "ROLE_ADMIN");
			userService.addRoleToUser("putin", "ROLE_SUPER_ADMIN");

		};
	}

}
