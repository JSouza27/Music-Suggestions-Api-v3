package br.com.musicsuggestions.mapper.interfaces;

import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "id", target = "userId"),
        @Mapping(source = "fullName", target = "fullName"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "password", target = "password", ignore = true),
        @Mapping(source = "createdAt", target = "createdAt"),
    })

    UserDTO userMap(User user);

    List<UserDTO> listMap(List<User> users);
}
