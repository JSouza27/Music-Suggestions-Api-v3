package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.authorization.SpotifyAuthorization;
import br.com.musicsuggestions.dto.SpotifyDTO;
import br.com.musicsuggestions.service.SpotifyService;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.message.BasicHttpRequest;
import org.apache.hc.core5.http.support.BasicRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/api/v3")
public class SpotifyController {

    @Autowired
    private SpotifyService service;

    @GetMapping("/spotify/authorization")
    ResponseEntity<HashMap> authorizationToken() throws IOException, ParseException, SpotifyWebApiException {
        String token = service.getToken();

        HashMap response = new HashMap<>();
        response.put("spotifyToken", token);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/spotify/playlist")
    ResponseEntity<String> getPlaylist(@RequestBody SpotifyDTO spotifyDTO) {
//        String response = service.getPlaylist(spotifyDTO.getCategoryId(), spotifyDTO.getToken());
//
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(response);
        return null;
    }
}
