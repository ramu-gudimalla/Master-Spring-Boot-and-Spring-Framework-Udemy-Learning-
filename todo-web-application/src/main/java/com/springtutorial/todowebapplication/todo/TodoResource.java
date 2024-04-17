package com.springtutorial.todowebapplication.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    @Autowired
    private  TodoService todoService;
    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){
        return todoService.findByUserName(username);
    }
    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable Integer id){
        return todoService.findById(id);
    }
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return todo;
    }
    @PostMapping("/users/{username}/todos/{id}")
    public Todo createTodo(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo){
        Todo createdTodo = todoService.addTodo (username, todo.getDescription(), todo.getTargetDate(),todo.isDone());
        return createdTodo;
    }
}
