package com.rest.webservices.restfulwebservices.socialmediaAppDemo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 10,message = "Post description should have more than 10 characters")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
