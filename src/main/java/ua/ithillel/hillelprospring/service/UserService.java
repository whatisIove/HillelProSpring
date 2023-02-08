package ua.ithillel.hillelprospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.exception.UserException;
import ua.ithillel.hillelprospring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(final int id) {
        return userRepository.getById(id);
    }

    public User getUserByEmailAndPhone(final String email, final Long phone) throws UserException {
        return userRepository.getUserByEmailAndPhone(email, phone);
    }

    public User getByAgeOrEmailOrPhone(final Integer age, final String email, final Long phone) throws UserException {
        return userRepository.getByAgeOrEmailOrPhone(age, email, phone);
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public User update(final Integer id, final User user) {
        return userRepository.update(id, user);
    }

    public Integer delete(final Integer id) {
        userRepository.delete(id);
        return id;
    }
}