package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.BodyDTO;
import br.com.musicsuggestions.service.PlaylistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

@Controller
@RequestMapping("api/v3")
public class PlaylistController {

    @Autowired
    PlaylistService service;

    @GetMapping("/playlist")
    ResponseEntity<Object> getPlaylist(@RequestBody BodyDTO body) throws IOException, ParseException, SpotifyWebApiException {
        Object playlist = service.getPlaylist(body);


        return ResponseEntity
            .status(HttpStatus.OK)
            .body(playlist);
    }
}
