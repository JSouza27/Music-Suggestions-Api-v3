package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.service.PlaylistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v3")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/playlist/{userId}/{city}")
    ResponseEntity<Object> getPlaylist(@PathVariable Long userId, @PathVariable String city) throws JsonProcessingException {
        Object playlist = playlistService.getPlaylist(userId, city);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(playlist);
    }
}
