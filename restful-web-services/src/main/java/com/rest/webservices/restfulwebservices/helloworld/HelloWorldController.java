package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
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
}
