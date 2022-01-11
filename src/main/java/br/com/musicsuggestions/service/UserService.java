package br.com.musicsuggestions.service;

import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.repository.UserRepository;
import br.com.musicsuggestions.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private Validator validator;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user) {
        Set<ConstraintViolation<User>> validations = validator.validate(user);

        if (!validations.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();

            for (ConstraintViolation<User> constraintViolation : validations) {
                stringBuilder.append(constraintViolation.getMessage());
            }

            throw new ConstraintViolationException("Erro: " + stringBuilder.toString(), validations);
        }

        User newUser = userRepository.save(user);
        return String.format("Usuário %s adicionado com sucesso!", newUser.getFullName());
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
