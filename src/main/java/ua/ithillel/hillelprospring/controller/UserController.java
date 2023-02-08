package ua.ithillel.hillelprospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.hillelprospring.controller.dto.IntegerDto;
import ua.ithillel.hillelprospring.controller.dto.UserDto;
import ua.ithillel.hillelprospring.controller.mapper.UserMapper;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.exception.UserException;
import ua.ithillel.hillelprospring.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(final UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(
                userService.getAll().stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable final int id) {
        return ResponseEntity.ok(userMapper.toDto(userService.getById(id)));
    }

    @GetMapping("/filter")
    public ResponseEntity<UserDto> getByEmailAndPhone(
            @RequestParam final String email,
            @RequestParam final Long phone) throws UserException {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserByEmailAndPhone(email, phone)));
    }

    @GetMapping("/filterSecond")
    public ResponseEntity<UserDto> getByAgeOrEmailOrPhone(
            @RequestParam final Integer age,
            @RequestParam(required = false) final String email,
            @RequestParam(required = false) final Long phone) throws UserException {
        return ResponseEntity.ok(userMapper.toDto(userService.getByAgeOrEmailOrPhone(age, email, phone)));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody final UserDto userDto) {
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.save(
                                userMapper.toEntity(userDto))),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public User update(@PathVariable final Integer id, @RequestBody final User user) {
        return userService.update(id, user);
    }

    @DeleteMapping
    public IntegerDto delete(@RequestParam final Integer id) {
        return new IntegerDto(userService.delete(id));
    }
}