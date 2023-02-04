package ua.ithillel.hillelprospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getById(final Integer id) {
        return userService.getById(id);
    }
}
