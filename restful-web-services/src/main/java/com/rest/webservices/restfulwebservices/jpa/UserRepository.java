package com.rest.webservices.restfulwebservices.jpa;
import com.rest.webservices.restfulwebservices.socialmediaAppDemo.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Integer> {
}
