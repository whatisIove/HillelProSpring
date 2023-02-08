package ua.ithillel.hillelprospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HillelProSpringApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(HillelProSpringApplication.class, args);

    }
}