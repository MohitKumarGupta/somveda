package com.somveda.service;

import java.util.List;

import com.somveda.entity.Song;
import com.somveda.exception.SomvedaException;

public interface SomvedaService {
	
	List<Song> all();
	List<Song> allByTitle(String title);
	String rateSong(String id, Integer rating) throws SomvedaException;
}
