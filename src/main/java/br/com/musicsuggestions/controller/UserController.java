package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user/register")
    ResponseEntity<Object> save(@RequestBody User userRegistration)  {
        userRegistration.setCreatedAt(LocalDateTime.now());
        Object response = service.save(userRegistration);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping("/user/search={userId}")
    ResponseEntity<User> getById(@PathVariable("userId") Long userId) {
        Optional<User> response = service.getById(userId);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response.get());
    }


    @GetMapping("/user/list")
    ResponseEntity<List<User>> getAllUsers() {
        List<User> response = service.getAllUsers();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @PutMapping("/user/update={id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User response = service.updateUser(id, user);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @DeleteMapping("/user/delete={userId}")
    ResponseEntity<String> delete(@PathVariable("userId") Long userId) {
        String response = service.delete(userId);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }
}
