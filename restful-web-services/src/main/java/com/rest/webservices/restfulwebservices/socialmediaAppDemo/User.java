package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private Integer id;
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Date should be in past")
    private LocalDate birthDate;
}
