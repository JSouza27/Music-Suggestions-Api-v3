package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.OpenWeatherMapDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapService {

    String url = "http://api.openweathermap.org/data/2.5/weather?q=";
    String apiKey = "&appid=6672b556198081a055b9cd8ade1497d7&units=metric";

    public int getTemperature(String city) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String jsonString = restTemplate.getForObject(url + city + apiKey, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode temp = mapper.readTree(jsonString).get("main").get("temp");

        return temp.intValue();
    }
}
