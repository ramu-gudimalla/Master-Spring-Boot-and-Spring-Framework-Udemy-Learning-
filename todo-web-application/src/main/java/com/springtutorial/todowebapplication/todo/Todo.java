package com.springtutorial.todowebapplication.todo;


import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;



@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
    private Integer id;
    private String userName;
    @Size(min = 10,message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
