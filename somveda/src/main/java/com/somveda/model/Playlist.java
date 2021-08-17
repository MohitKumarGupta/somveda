package com.somveda.model;

import java.util.Map;

import lombok.Data;

@Data
public class Playlist {
	
	 Map<String,String> id;
	 Map<String,String> title;
	 Map<String,Double> danceability;
	 Map<String,Double> energy;
	 Map<String,Long> key;
	 Map<String,Double> loudness;
	 Map<String,Long> mode; 
	 Map<String,Double> acousticness;
	 Map<String,Double> instrumentalness;
	 Map<String,Double> liveness;
	 Map<String,Double>	valence;
	 Map<String,Double> tempo;
	 Map<String,Long> duration_ms;
	 Map<String,Long> time_signature;
	 Map<String,Long> num_bars;
	 Map<String,Long> num_sections;
	 Map<String,Long> num_segments;
	 Map<String,Long> _class;
}
