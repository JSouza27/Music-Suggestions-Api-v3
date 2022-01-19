package br.com.musicsuggestions.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaylistService {

    @Autowired
    OpenWeatherMapService openWeatherMapService;


    public Object getPlaylist(Long userId, String city) throws JsonProcessingException {
        int temperature = openWeatherMapService.getTemperature(city);

        return temperature;
    }
}
