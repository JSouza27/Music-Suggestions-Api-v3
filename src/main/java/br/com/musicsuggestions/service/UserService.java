package br.com.musicsuggestions.service;

import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.repository.UserRepository;
import br.com.musicsuggestions.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        User newUser = userRepository.save(user);

        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User obj) {
        User user = getById(id).get();

        user.setEmail(obj.getEmail());
        user.setFullName(obj.getFullName());
        user.setPassword(obj.getPassword());

        return userRepository.save(user);
    }

    @Override
    public String delete(Long id) {
        String message = "Usuário deletado com sucesso!";
        userRepository.deleteById(id);
        return message;
    }
}
