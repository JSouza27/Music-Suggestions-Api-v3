package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.BodyDTO;
import br.com.musicsuggestions.dto.OpenWeatherMapDTO;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;

import java.io.IOException;

@Service
public class PlaylistService {

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private HistoricService historicService;

    @Autowired
    OpenWeatherMapService openWeatherMapService;

    public Paging<PlaylistSimplified> getPlaylist(BodyDTO body) throws IOException, ParseException, SpotifyWebApiException {
        OpenWeatherMapDTO openWeather = openWeatherMapService.getOpenWeather(body.getCity());
        double temperature = openWeather.getTemp();

        Paging<PlaylistSimplified> playlist = null;

        if (temperature > 30) {
            playlist = spotifyService.getSpotifyPlaylist("party", body.getSpotifyToken());
        }
        if (temperature > 15 && temperature < 30) {
            playlist = spotifyService.getSpotifyPlaylist("pop", body.getSpotifyToken());
        }
        if (temperature > 10 && temperature < 14) {
            playlist = spotifyService.getSpotifyPlaylist("rock", body.getSpotifyToken());
        }
        if (temperature < 10) {
            playlist = spotifyService.getSpotifyPlaylist("classical", body.getSpotifyToken());
        }
        
        return playlist;
    }
}
