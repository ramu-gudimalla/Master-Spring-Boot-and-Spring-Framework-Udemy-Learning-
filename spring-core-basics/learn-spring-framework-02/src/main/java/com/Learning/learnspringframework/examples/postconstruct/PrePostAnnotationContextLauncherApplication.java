package com.Learning.learnspringframework.examples.postconstruct;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private final SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency){
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }
    @PostConstruct
    public void initialize(){
        someDependency.someMethod();
    }
    @PreDestroy // performs clean up tasks or release resources
    public void cleanUp(){
        System.out.println("Clean Up");
    }
}
@Component
class SomeDependency{
    public void someMethod(){
        System.out.println("someMethod in someDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);
        System.out.println("Starting the application");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        context.close();
    }
}
