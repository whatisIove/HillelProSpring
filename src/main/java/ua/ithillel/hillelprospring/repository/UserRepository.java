package ua.ithillel.hillelprospring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelprospring.configuration.BeanConfiguration;
import ua.ithillel.hillelprospring.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private final BeanConfiguration beanConfiguration;

    public UserRepository(BeanConfiguration beanConfiguration) {
        this.beanConfiguration = beanConfiguration;
    }

    @PostConstruct
    public void initialization() {
        users.add(beanConfiguration.getUserForAdministration());
        users.add(new User(1, "User", "User", 18, "user@gmail.com"));
        users.add(new User(2, "Support", "Support", 18, "support@gmail.com"));
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(final Integer id) {
        return users.get(id);
    }

}