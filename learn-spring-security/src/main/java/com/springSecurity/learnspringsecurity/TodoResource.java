package com.springSecurity.learnspringsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    Logger logger = LoggerFactory.getLogger(LoggingApplicationListener.class);
    public static final List<Todo> TODOS = List.of(new Todo("Ram", "Learn Spring"),
            new Todo("Ram", "Learn Devops"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODOS;
    }
    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodoForSpecificUser(@PathVariable String username){
        return TODOS.get(0);
    }
    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create Post request is called");
    }
}

record Todo(String username, String description){}