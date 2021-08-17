package com.somveda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somveda.entity.Song;

import java.util.List;

@Repository
public interface SomvedaRepository extends JpaRepository<Song, String> {
	List<Song> findByTitle(String title);
}
