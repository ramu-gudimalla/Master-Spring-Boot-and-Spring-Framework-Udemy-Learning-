package com.Learning.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingBasic {
    public static void main(String[] args) {
        // 1. Launch a Spring Context

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. Configure the things that we want Spring to manage -
        // HelloWorldConfiguration @Configuration
        //name - @Bean
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2WithMethodCalls"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("person3Parameters"));
        //System.out.println(context.getBean(Address.class));
    }
}
