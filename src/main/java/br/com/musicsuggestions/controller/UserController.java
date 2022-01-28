package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.mapper.UserMapperIml;
import br.com.musicsuggestions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapperIml mapper;

    @PostMapping("/user/register")
    ResponseEntity<UserDTO> save(@Valid @RequestBody User userRegistration)  {
            userRegistration.setCreatedAt(LocalDateTime.now());
            User response = service.save(userRegistration);
            UserDTO user = mapper.userMap(response);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping("/user/search={userId}")
    ResponseEntity<User> getById(@Valid @PathVariable("userId") Long userId) {
        Optional<User> response = service.getById(userId);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response.get());
    }


    @GetMapping("/user/list")
    ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> response = service.getAllUsers();
        List<UserDTO> allUsers = mapper.listMap(response);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(allUsers);
    }

    @PutMapping("/user/update={id}")
    ResponseEntity<User> updateUser(@Valid @PathVariable("id") Long id, @Valid @RequestBody User user) {
        User response = service.updateUser(id, user);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @DeleteMapping("/user/delete={userId}")
    ResponseEntity<String> delete(@Valid @PathVariable("userId") Long userId) {
        try {
            String response = service.delete(userId);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Usuário não encontrado", e
            );
        }
    }
}
