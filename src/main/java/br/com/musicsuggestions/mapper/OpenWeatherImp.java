package br.com.musicsuggestions.mapper;

import br.com.musicsuggestions.dto.OpenWeatherMapDTO;
import br.com.musicsuggestions.mapper.interfaces.OpenWeatherMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherImp implements OpenWeatherMapper {
    @Override
    public OpenWeatherMapDTO map(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }

        OpenWeatherMapDTO mapDTO = new OpenWeatherMapDTO();

        mapDTO.setHumidity(jsonNode.get("humidity").intValue());
        mapDTO.setPressure(jsonNode.get("pressure").intValue());
        mapDTO.setTemp(jsonNode.get("temp").intValue());
        mapDTO.setTempMax(jsonNode.get("temp_max").intValue());
        mapDTO.setTempMin(jsonNode.get("temp_min").intValue());
        mapDTO.setFeelsLike(jsonNode.get("feels_like").intValue());

        return mapDTO;
    }
}
