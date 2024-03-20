package com.springtutorial.todowebapplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping(value = "/")
    public String gotoWelcomePage(ModelMap modelMap){
        modelMap.put("name","ram");
        return "welcome";
    }
}
