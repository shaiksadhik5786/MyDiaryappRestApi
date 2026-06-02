package com.web.springbootmydiary.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.springbootmydiary.restapi.entity.User;
import com.web.springbootmydiary.restapi.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
	List<Entry> findAllByUser(User user);
}
