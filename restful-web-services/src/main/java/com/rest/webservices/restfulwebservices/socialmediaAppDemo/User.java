package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
