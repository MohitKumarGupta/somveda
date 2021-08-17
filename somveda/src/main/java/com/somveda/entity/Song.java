package com.somveda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "song")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song {
	
	@Id
	 String id;
	 String title;
	 Double danceability;
	 Double energy;
	 Long key;
	 Double loudness;
	 Long mode; 
	 Double acousticness;
	 Double instrumentalness;
	 Double liveness;
	 Double	valence;
	 Double tempo;
	 Long duration_ms;
	 Long time_signature;
	 Long num_bars;
	 Long num_sections;
	 Long num_segments;
	 @Column(name = "class")
	 Long _class;
	 Integer star_rating;

}
