package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.authorization.SpotifyAuthorization;
import br.com.musicsuggestions.service.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;
import java.net.URI;

@Controller
@RequestMapping("/api/v3")
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private SpotifyAuthorization spotifyAuthorization;

    private String clientId = "b8b29b4f9fc94271b167bb488524bcd2";
    private String clientSecret = "b6c4763d693540a3af2da6c19c04c75c";

    @GetMapping("/spotify/authorization")
    ResponseEntity<SpotifyApi> authorizationToken() throws IOException, ParseException, SpotifyWebApiException {

        SpotifyApi spotifyApi = spotifyAuthorization.getSpotifyBuilder(clientId, clientSecret);
        spotifyService.getToken(spotifyApi);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(spotifyApi);
    }
}
