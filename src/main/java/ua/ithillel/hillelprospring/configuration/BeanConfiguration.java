package ua.ithillel.hillelprospring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ua.ithillel.hillelprospring.entity.User;

@Configuration
@ComponentScan("ua.ithillel.hillelprospring.configuration")
@PropertySource("classpath:application.properties")
public class BeanConfiguration {

    @Value("${default.text}")
    private String defaultText;

    @Value("${default.year}")
    private Integer defaultYear;

    @Bean
    @Scope("prototype")
    public User getUserForAdministration() {
        return new User(0, "Admin", "Admin", 2023, "admin@gmail.com", 12L);
    }

    @Bean
    public String getDefaultText() {
        return defaultText;
    }

    @Bean
    public Integer getDefaultYear() {
        return defaultYear;
    }
}


