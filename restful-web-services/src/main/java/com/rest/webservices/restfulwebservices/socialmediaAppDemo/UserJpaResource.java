package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@RestController
public class UserJpaResource {
     private UserRepository userRepository;
     @RequestMapping(path = "/jpa/users",method = RequestMethod.GET)
     public List<User> retrieveAllUsers(){
         return userRepository.findAll();
     }

     @GetMapping("/jpa/users/{id}")
     public EntityModel<User> retrieveUser(@PathVariable Integer id){
         Optional<User> user =userRepository.findById(id);
         if(user.isEmpty())
             throw new UserNotFoundException("id "+id);
         EntityModel<User> entityModel = EntityModel.of(user.get());
         WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
         entityModel.add(webMvcLinkBuilder.withRel("all-users"));
         return entityModel;
     }
     @DeleteMapping("/jpa/users/{id}")
     public void deleteUser(@PathVariable Integer id){
         userRepository.deleteById(id);
     }
     @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
         User savedUser = userRepository.save(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
     }
}
