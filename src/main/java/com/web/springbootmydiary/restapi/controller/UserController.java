package com.web.springbootmydiary.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.springbootmydiary.restapi.entity.User;
import com.web.springbootmydiary.restapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> findAll()
	{
		List<User> users = userService.findAll();
		
		return users;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable int id)
	{
		User user = userService.findById(id);
		
		return user;
	}
}
