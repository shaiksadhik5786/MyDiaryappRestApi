package com.web.springbootmydiary.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.springbootmydiary.restapi.entity.User;
import com.web.springbootmydiary.restapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	@Override
	public User findById(long id) {
		return userRepository.findById(id).get();
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
