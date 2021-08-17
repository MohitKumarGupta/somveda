package com.somveda.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.somveda.entity.Song;
import com.somveda.model.Playlist;
import com.somveda.repository.SomvedaRepository;
 
@Service
public class ReadJson
{
	@Value("classpath:resources/playlist.json")
	static Resource resourceFile;
	
	@Autowired
	SomvedaRepository repo;
	
	@PostConstruct
    @SuppressWarnings("unchecked")
	public void main() 
    {
        JSONParser jsonParser = new JSONParser();
        String path = "D:\\Spring Workspace\\somveda\\src\\main\\resources\\playlist.json";
        try (FileReader reader = new FileReader(path))
        {
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
 
            Playlist playList = new Playlist();
	       	playList.setId((Map<String, String>)obj.get("id")); 
	       	playList.setTitle((Map<String, String>)obj.get("title"));
	       	playList.setDanceability((Map<String, Double>)obj.get("danceability"));
	       	playList.setEnergy((Map<String, Double>)obj.get("energy"));
	       	playList.setKey((Map<String, Long>)obj.get("key"));
	       	playList.setLoudness((Map<String, Double>)obj.get("loudness"));
	       	playList.setMode((Map<String, Long>)obj.get("mode"));
	       	playList.setAcousticness((Map<String, Double>)obj.get("acousticness"));
	       	playList.setInstrumentalness((Map<String, Double>)obj.get("instrumentalness"));
	       	playList.setLiveness((Map<String, Double>)obj.get("liveness"));
	       	playList.setValence((Map<String, Double>)obj.get("valence"));
	       	playList.setTempo((Map<String, Double>)obj.get("tempo"));
	       	playList.setDuration_ms((Map<String, Long>)obj.get("duration_ms"));
	       	playList.setTime_signature((Map<String, Long>)obj.get("time_signature"));
	       	playList.setNum_bars((Map<String, Long>)obj.get("num_bars"));
	       	playList.setNum_sections((Map<String, Long>)obj.get("num_sections"));
	       	playList.setNum_segments((Map<String, Long>)obj.get("num_segments"));
	       	playList.set_class((Map<String, Long>)obj.get("class"));
	       	parsePlayListObject(playList);
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private void parsePlayListObject(Playlist playList) 
    {
    	List<Song> songs = new ArrayList<>();
    	playList.getId().forEach((key,value)->{
    		Song song = new Song();
    		song.setId(value);
    		song.setTitle(playList.getTitle().get(key));
	       	song.setDanceability(playList.getDanceability().get(key));
	       	song.setEnergy(playList.getEnergy().get(key));
	       	song.setKey(playList.getKey().get(key));
	       	song.setLoudness(playList.getLoudness().get(key));
	       	song.setMode(playList.getMode().get(key));
	       	song.setAcousticness(playList.getAcousticness().get(key));
	       	song.setInstrumentalness(playList.getInstrumentalness().get(key));
	       	song.setLiveness(playList.getLiveness().get(key));
	       	song.setValence(playList.getValence().get(key));
	       	song.setTempo(playList.getTempo().get(key));
	       	song.setDuration_ms(playList.getDuration_ms().get(key));
	       	song.setTime_signature(playList.getTime_signature().get(key));
	       	song.setNum_bars(playList.getNum_bars().get(key));
	       	song.setNum_sections(playList.getNum_sections().get(key));
	       	song.setNum_segments(playList.getNum_segments().get(key));
	       	song.set_class(playList.get_class().get(key));
	       	songs.add(song);
    	});
//    	System.out.println(songs);
    	repo.saveAll(songs);
    }
}
