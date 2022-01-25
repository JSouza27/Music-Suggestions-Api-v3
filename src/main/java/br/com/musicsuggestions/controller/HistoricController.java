package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.repository.HistoricRepository;
import br.com.musicsuggestions.service.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v3")
public class HistoricController {

    @Autowired
    private HistoricService service;

    @GetMapping("/historic")
    ResponseEntity<Historic> getAll() {
        Historic response = service.;
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
