package com.springtutorial.todowebapplication.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class SayHelloController {
    @GetMapping(path = "/basicAuth")
    public String basicAuthChecker(){
        return "Success";
    }
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you doing today! glad to meet you";
    }

    @RequestMapping("say-hello-bean")
    @ResponseBody
    public HelloWorldBean sayHelloBean(){
        return new HelloWorldBean("Hello World from Bean");
    }
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
