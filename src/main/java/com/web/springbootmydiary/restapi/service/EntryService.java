package com.web.springbootmydiary.restapi.service;

import java.util.List;

import com.web.springbootmydiary.restapi.entity.Entry;
import com.web.springbootmydiary.restapi.entity.User;

public interface EntryService {
	
	Entry save(Entry entry);
	Entry update(Entry entry);
	void delete(Entry entry);
	List<Entry> findAllByUser(User user);
	Entry findById(long id);
	List<Entry> findAll();
}
