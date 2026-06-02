package com.web.springbootmydiary.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.springbootmydiary.restapi.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsernameAndPassword(String username, String password);
}
