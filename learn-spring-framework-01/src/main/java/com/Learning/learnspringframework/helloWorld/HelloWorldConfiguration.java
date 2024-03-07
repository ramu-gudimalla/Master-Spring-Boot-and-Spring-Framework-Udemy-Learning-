package com.Learning.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Eliminate verbosity in creating Java Beans
// Public accessor methods, constructor, equals,
// hashcode and toString are automatically created
// Released in JDK 16.

record  Person(String name, Integer age,Address address){  };
record Address(String firstLine,String city){};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return  "Ram";
    }
    @Bean
    public Integer age(){
        return 21;
    }
    @Bean
    public Person person(){
        return new Person("Ravi",20, new Address("Gachibowli","Hyderabad"));
    }
    @Bean
    public Person person2WithMethodCalls(){
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3Parameters(String name,Integer age, Address address3){
        return new Person(name,age,address3);
    }
    @Bean
    public Person person4Parameters(String name,Integer age, @Qualifier("address3Qualifier") Address address3){
        return new Person(name,age,address3);
    }
    @Bean(name="address") //yourCustomBean name
    @Primary //if we have multiple beans with same class name we can use primary to make a class default
    public Address address(){
        return new Address("Street 2","New Jersey");
    }
    @Bean
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("JNTU COLLEGE","Hyderabad");
    }
}
