package ua.ithillel.hillelprospring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Long phone;
}
