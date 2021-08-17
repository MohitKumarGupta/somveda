DROP TABLE IF EXISTS song;

CREATE TABLE song (

id VARCHAR(250) PRIMARY KEY,
title VARCHAR(250),
danceability double,
energy double,
key int,
loudness double,
mode int,
acousticness double,
instrumentalness double,
liveness double,
valence double,
tempo double,
duration_ms int,
time_signature int,
num_bars int,
num_sections int,
num_segments int,
class int,
star_rating int
);