package com.web.springbootmydiary.restapi.service;

import java.util.List;

import com.web.springbootmydiary.restapi.entity.User;

public interface UserService {
	
	User save(User user);
	User findByUsernameAndPassword(String username, String password);
	User findById(long id);
	List<User> findAll();
}
