package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
     }

     @GetMapping("/users/{id}")
     public EntityModel<User> retrieveUser(@PathVariable Integer id){
         User user = userDaoService.findOne(id);
         if(user == null)
             throw new UserNotFoundException("id "+id);
         EntityModel<User> entityModel = EntityModel.of(user);
         WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
         entityModel.add(webMvcLinkBuilder.withRel("all-users"));
         return entityModel;
     }
     @DeleteMapping("/users/{id}")
     public void deleteUser(@PathVariable Integer id){
         userDaoService.deleteById(id);
     }
     @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
         User savedUser = userDaoService.save(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
     }
}
