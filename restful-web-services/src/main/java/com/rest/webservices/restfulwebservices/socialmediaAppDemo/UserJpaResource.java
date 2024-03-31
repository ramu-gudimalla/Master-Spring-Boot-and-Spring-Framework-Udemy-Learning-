package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import com.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserJpaResource {
     private UserRepository userRepository;
     private PostRepository postRepository;
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
     @GetMapping("/jpa/users/{id}/posts")
     public List<Post> retrievePostsOfUser(@PathVariable Integer id){
         Optional<User> user = userRepository.findById(id);
         if(user.isEmpty())
             throw new UserNotFoundException("id: "+id);
         return user.get().getPosts();
     }
     @PostMapping("/jpa/users/{id}/posts")
     public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post){
         Optional<User> user = userRepository.findById(id);
         if(user.isEmpty())
             throw new UserNotFoundException("id: "+id);
         post.setUser(user.get());
         Post savedPost = postRepository.save(post);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}").buildAndExpand(savedPost.getId()).toUri();
         return ResponseEntity.created(location).build();
     }
//     @GetMapping("/jpa/users/{userId}/posts/{postId}")
//     public Optional<Post> retrievePostById(@PathVariable Integer userId, @PathVariable Integer postId, @RequestBody Post post){
//         Optional<User> user = userRepository.findById(userId);
//         post.setUser(user.get());
//         log.info(""+postRepository.findById(post.getId()));
//         return postRepository.findById(post.getId());
//     }
}
