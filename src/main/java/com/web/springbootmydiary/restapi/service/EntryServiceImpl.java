package com.web.springbootmydiary.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.springbootmydiary.restapi.entity.Entry;
import com.web.springbootmydiary.restapi.entity.User;
import com.web.springbootmydiary.restapi.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	@Override
	public Entry save(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public Entry update(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void delete(Entry entry) {
		entryRepository.delete(entry);
	}

	@Override
	public Entry findById(long id) {
		return entryRepository.findById(id).get();
	}

	@Override
	public List<Entry> findAllByUser(User user) {
		return entryRepository.findAllByUser(user);
	}

	@Override
	public List<Entry> findAll() {
		return entryRepository.findAll();
	}

}
