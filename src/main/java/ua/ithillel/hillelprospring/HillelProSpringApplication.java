package ua.ithillel.hillelprospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.hillelprospring.configuration.BeanConfiguration;
import ua.ithillel.hillelprospring.controller.UserController;
import ua.ithillel.hillelprospring.entity.User;

import java.util.List;

@SpringBootApplication
public class HillelProSpringApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(HillelProSpringApplication.class, args);
        final UserController userController = context.getBean(UserController.class);
        final List<User> users = userController.getAll();
        users.forEach(System.out::println);
        final User user = userController.getById(2);
        System.out.println(user);


        final AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);

        final String defaultText = annotationConfigApplicationContext.getBean("getDefaultText", String.class);
        System.out.println("defaultText: " + defaultText);

        final Integer defaultYear = annotationConfigApplicationContext.getBean("getDefaultYear", Integer.class);
        System.out.println("defaultYear: " + defaultYear);

        final User admin = annotationConfigApplicationContext.getBean("getUserForAdministration", User.class);
        System.out.println("getUserForAdministration: " + admin);

    }

}