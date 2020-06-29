package com.zabeer.sbmysql.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zabeer.sbmysql.entity.Users;
import com.zabeer.sbmysql.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/{id}")
	public Users getUser(@PathVariable ("id") Integer id) {
		return userService.getUserById(id);
	}

}
