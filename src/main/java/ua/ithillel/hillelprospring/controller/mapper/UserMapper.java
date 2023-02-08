package ua.ithillel.hillelprospring.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.hillelprospring.controller.dto.UserDto;
import ua.ithillel.hillelprospring.entity.User;

@Component
public class UserMapper {
    public UserDto toDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User toEntity(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getEmail(),
                userDto.getPhone()
        );
    }
}
