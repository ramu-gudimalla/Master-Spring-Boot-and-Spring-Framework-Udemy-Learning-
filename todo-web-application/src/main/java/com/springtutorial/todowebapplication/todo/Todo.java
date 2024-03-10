package com.springtutorial.todowebapplication.todo;


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
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
