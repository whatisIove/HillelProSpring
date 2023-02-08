package ua.ithillel.hillelprospring.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private int id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Long phone;

}