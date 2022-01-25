package br.com.musicsuggestions.mapper.interfaces;

import br.com.musicsuggestions.dto.OpenWeatherMapDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OpenWeatherMapper {

    @Mappings({
        @Mapping(source = "temp", target = "temp"),
        @Mapping(source = "feels_like", target = "feelsLike"),
        @Mapping(source = "temp_min", target = "tempMin"),
        @Mapping(source = "temp_max", target = "tempMax"),
        @Mapping(source = "pressure", target = "pressure"),
        @Mapping(source = "humidity", target = "humidity"),
        @Mapping(source = "sea_level", target = "sea_level", ignore = true),
        @Mapping(source = "grnd_level", target = "grnd_level", ignore = true),
    })

    OpenWeatherMapDTO map(JsonNode jsonNode);
}
