package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.repository.HistoricRepository;
import br.com.musicsuggestions.service.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v3")
public class HistoricController {

    @Autowired
    private HistoricService service;

    @GetMapping("/historic/{userId}")
    ResponseEntity<List<Historic>> getById(@Valid @PathVariable Long userId) {
        List<Historic> response = service.getPlayListByUser(userId);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/historic")
    ResponseEntity<List<Historic>> getAll() {
        List<Historic> response = service.getAll();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
