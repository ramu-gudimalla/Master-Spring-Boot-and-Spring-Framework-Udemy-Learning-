package com.rest.webservices.restfulwebservices.socialmediaAppDemo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static int userCount=0;
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++userCount,"Ram", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount,"Laxman", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount,"Prashanth", LocalDate.now().minusYears(25)));
    }
    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
