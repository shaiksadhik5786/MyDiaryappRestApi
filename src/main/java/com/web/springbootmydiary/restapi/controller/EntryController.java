package com.web.springbootmydiary.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.springbootmydiary.restapi.entity.Entry;
import com.web.springbootmydiary.restapi.service.EntryService;

@RestController
@RequestMapping("/entries")
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@GetMapping("/")
	public List<Entry> findAll()
	{
		List<Entry> entries = entryService.findAll();
		return entries;
	}
	
	@PostMapping("/")
	public Entry addEntry(@RequestBody Entry entry)
	{
		Entry entry1 = entryService.save(entry);
		
		return entry1;
	}
	
	@PutMapping("/")
	public Entry updateEntry(@RequestBody Entry entry)
	{
		Entry entry1 = entryService.update(entry);
		
		return entry1;
	}
	
	@PutMapping("/{id}")
	public Entry updateEntry(@PathVariable("id") int id,@RequestBody Entry entry)
	{
		Entry entryUpdate = entryService.findById(id);
		
		entryUpdate.setDescription(entry.getDescription());
		entryUpdate.setEntrydate(entry.getEntrydate());
		entryUpdate.setUser(entry.getUser());
		
		Entry entry1 = entryService.update(entryUpdate);
		
		return entry1;
	}
	
	@PatchMapping("/{id}")
	public Entry addEntry(@PathVariable("id") int id,@RequestBody Entry entry)
	{
		Entry entryUpdate = entryService.findById(id);
		
		if(entry.getDescription() != null)
			entryUpdate.setDescription(entry.getDescription());
		if(entry.getEntrydate() != null)
			entryUpdate.setEntrydate(entry.getEntrydate());
		if(entry.getUser() != null)
			entryUpdate.setUser(entry.getUser());
		
		Entry entry1 = entryService.update(entryUpdate);
		
		return entry1;
	}
	
	@GetMapping("/{id}")
	public Entry getEntry(@PathVariable("id") int id)
	{
		Entry entry1 = entryService.update(entryService.findById(id));
		
		return entry1;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEntry(@PathVariable("id") int id)
	{
		Entry entry = entryService.findById(id);
		
		entryService.delete(entry);
	}
}
