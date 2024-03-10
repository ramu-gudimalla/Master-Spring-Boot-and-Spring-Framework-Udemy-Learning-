package com.springtutorial.todowebapplication.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {
    public boolean authenticate(String name,String password){
        boolean isValidUserName = name.equalsIgnoreCase("ram");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUserName && isValidPassword;
    }
}
