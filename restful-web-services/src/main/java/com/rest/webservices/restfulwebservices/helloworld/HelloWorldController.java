package com.rest.webservices.restfulwebservices.helloworld;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@AllArgsConstructor
public class HelloWorldController {
    private MessageSource messageSource;
    @RequestMapping(path ="/hello",method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }
    @RequestMapping(path ="/hello-bean",method = RequestMethod.GET)
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
    @RequestMapping(path ="/hello/path-variable/{name}",method = RequestMethod.GET)
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
    @RequestMapping(path ="/hello-in",method = RequestMethod.GET)
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
