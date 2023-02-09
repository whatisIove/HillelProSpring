package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(final Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getUserByEmailAndPhone(final String email, final Long phone) {
        return userRepository.getUserByEmailAndPhone(email, phone);
    }

    public User getByAgeOrEmailOrPhone(final Integer age, final String email, final Long phone) {
        return userRepository.getByAgeOrEmailOrPhone(age, email, phone);
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public User update(final User user) {
        return userRepository.save(user);
    }

    public Integer delete(final Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    public Integer updateNameAndSurnameById(final Integer id, final String name, final String surname) {
        return userRepository.updateNameAndSurnameById(id, name, surname);
    }
}