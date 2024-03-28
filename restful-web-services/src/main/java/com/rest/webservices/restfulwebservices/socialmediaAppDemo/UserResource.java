package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
         User user = userDaoService.findOne(id);
         if(user == null){
             throw new UserNotFoundException("id "+id);
         }
        return user;
     }
     @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
         User savedUser = userDaoService.save(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
     }
}
