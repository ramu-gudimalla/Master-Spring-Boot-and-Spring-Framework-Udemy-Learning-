package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "User_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2,message = "Name should have at least 2 characters")
//    @JsonProperty("User Name")
    private String name;
    @Past(message = "Date should be in past")
//    @JsonProperty("Date of Birth")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
}
