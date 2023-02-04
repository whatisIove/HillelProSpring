package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(final Integer id) {
        return userRepository.getById(id);
    }

}