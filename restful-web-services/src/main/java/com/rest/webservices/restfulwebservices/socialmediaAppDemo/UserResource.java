package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserResource {
     private UserDaoService userDaoService;
     @RequestMapping(path = "/users",method = RequestMethod.GET)
     public List<User> retrieveAllUsers(){
         return userDaoService.findAll();
     }@RequestMapping(path = "/users/{id}",method = RequestMethod.GET)
     public User retrieveSingleUser(@PathVariable Integer id){
         return userDaoService.findOne(id);
     }
     @PostMapping("/users")
    public void createUser(@RequestBody User user){
         userDaoService.save(user);
         ResponseEntity.created()
     }
}
