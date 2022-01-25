package br.com.musicsuggestions.mapper;

import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.mapper.interfaces.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperIml implements UserMapper {
    @Override
    public UserDTO userMap(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setHistoric(user.getHistoric());

        return userDTO;
    }

    @Override
    public List<UserDTO> listMap(List<User> users) {
        List<UserDTO> listOfUsers = new ArrayList<>();

        for (User user : users) {
            listOfUsers.add(userMap(user));
        }

        return listOfUsers;
    }
}
