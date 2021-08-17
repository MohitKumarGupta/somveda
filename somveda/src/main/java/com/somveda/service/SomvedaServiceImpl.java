package com.somveda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.somveda.entity.Song;
import com.somveda.exception.SomvedaException;
import com.somveda.repository.SomvedaRepository;

@Service
public class SomvedaServiceImpl implements SomvedaService{
	
	@Autowired
	SomvedaRepository repo;
	
	@Autowired
	Environment env;

	@Override
	public List<Song> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Song> allByTitle(String title) {
		// TODO Auto-generated method stub
		return repo.findByTitle(title);
	}

	@Override
	public String rateSong(String id, Integer rating) throws SomvedaException {
		// TODO Auto-generated method stub
		Optional<Song> songOptional = repo.findById(id);
		
		if(songOptional.isPresent()) {
			Song song =songOptional.get();
			song.setStar_rating(rating);
			repo.save(song);
		}else {
			throw new SomvedaException("song.notfound");
		}
		return env.getProperty("song.rating.updated");
	}
	
}
