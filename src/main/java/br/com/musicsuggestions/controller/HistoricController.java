package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v3")
public class HistoricController {

    @Autowired
    private HistoricRepository historicRepository;

    @PostMapping("/historic")
    ResponseEntity<Historic> save(@RequestBody Historic historic) {
        Historic response = historicRepository.save(historic);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
