package ua.ithillel.hillelprospring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelprospring.configuration.BeanConfiguration;
import ua.ithillel.hillelprospring.entity.User;
import ua.ithillel.hillelprospring.exception.UserException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private final BeanConfiguration beanConfiguration;

    public UserRepository(final BeanConfiguration beanConfiguration) {
        this.beanConfiguration = beanConfiguration;
    }

    @PostConstruct
    public void initialization() {
        users.add(beanConfiguration.getUserForAdministration());
        users.add(new User(1, "User", "User", 18, "user@gmail.com", 123L));
        users.add(new User(2, "Support", "Support", 18, "support@gmail.com", 1234L));
    }


    public List<User> getAll() {
        return users;
    }

    public User getById(final int id) {
        return users.get(id);
    }

    public User getUserByEmailAndPhone(final String email, final Long phone) throws UserException {
        for (User user : users) {
            if ((user.getEmail().equals(email)) && (user.getPhone().equals(phone))) {
                return user;
            }
        }
        throw new UserException("No matches found by email and phone.");
    }

    public User getByAgeOrEmailOrPhone(final Integer age, final String email, final Long phone) throws UserException {
        for (User user : users) {
            if ((user.getAge().equals(age)) || (user.getEmail().equals(email)) || (user.getPhone().equals(phone))) {
                return user;
            }
        }
        throw new UserException("No matches found by age or email or phone.");
    }

    public User save(final User user) {
        users.add(user);
        user.setId(users.size());
        return user;
    }

    public User update(final Integer id, final User user) {
        final User userForUpdate = users.get(id);
        userForUpdate.setEmail(user.getEmail());
        return users.get(id);

    }

    public Integer delete(final int id) {
        users.remove(id);
        return id;
    }
}
