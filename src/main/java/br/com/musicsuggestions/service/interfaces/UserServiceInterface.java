package br.com.musicsuggestions.service.interfaces;

import br.com.musicsuggestions.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    String save(User user);

    Optional<User> getById(Long id);

    Optional<User> getByEmail(String email);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    String delete(Long id);
}
