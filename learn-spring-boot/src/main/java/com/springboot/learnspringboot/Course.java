package com.springboot.learnspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String author;
}
