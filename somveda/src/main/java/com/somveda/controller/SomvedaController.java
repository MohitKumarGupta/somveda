package com.somveda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somveda.entity.Song;
import com.somveda.exception.SomvedaException;
import com.somveda.service.SomvedaService;

@RequestMapping("somveda/songs")
@RestController
public class SomvedaController {
	
	@Autowired
	SomvedaService service;
	
	@GetMapping()
	public List<Song> all(){
		return service.all();
	}
	
	@GetMapping("/{title}")
	public List<Song> allByTitle(@PathVariable String title){
		return service.allByTitle(title);
	}
	
	@PutMapping("/{id}/{rating}")
	public String rateSong(@PathVariable String id,@PathVariable Integer rating) throws SomvedaException{
		return service.rateSong(id, rating);
	}

}
