package com.springtutorial.todowebapplication.todo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@AllArgsConstructor
@Controller
@SessionAttributes("name")
public class todoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
        List<Todo> todos = todoService.findByUserName("Ram");
        modelMap.addAttribute("todos",todos);
        return "listTodos";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo(){
        return "addTodo";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description){
        return "redirect:list-todos";
    }
}
