package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.OpenWeatherMapDTO;
import br.com.musicsuggestions.mapper.OpenWeatherImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OpenWeatherMapService {

    @Autowired
    OpenWeatherImp mapper;

    @Value("${open-wather-map-api-key}")
    String apiKey;
    String url = "api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    public OpenWeatherMapDTO getOpenWeather(String city) throws JsonProcessingException {
        WebClient client = WebClient.create();
        Mono<String> responseJson = client.get()
            .uri(url, city, apiKey)
            .retrieve()
            .bodyToMono(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(responseJson.block()).get("main");

        OpenWeatherMapDTO response = mapper.map(json);

        return response;
    }
}
