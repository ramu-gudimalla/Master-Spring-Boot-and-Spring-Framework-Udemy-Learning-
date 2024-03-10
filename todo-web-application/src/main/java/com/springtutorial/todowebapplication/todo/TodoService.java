package com.springtutorial.todowebapplication.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TodoService {
//    private static final List<Todo> todos = new ArrayList<>();
//    static {
//        new Todo(1, "Ram", "Learn Java", LocalDate.now().plusYears(1), false);
//        new Todo(2, "Ram", "Learn SpringBoot", LocalDate.now().plusYears(2), false);
//        new Todo(3, "Ram", "Learn Dockers", LocalDate.now().plusYears(3), false);
//    }
private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "ram","Learn AWS",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(2, "ram","Learn DevOps",
                LocalDate.now().plusYears(2), false ));
        todos.add(new Todo(3, "ram","Learn Full Stack Development",
                LocalDate.now().plusYears(3), false ));
    }
    public List<Todo> findByUserName(String userName){
        return todos;
    }
    public void addTodo()
}
