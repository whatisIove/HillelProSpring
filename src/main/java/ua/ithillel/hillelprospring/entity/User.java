package ua.ithillel.hillelprospring.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Component
public class User {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;

}