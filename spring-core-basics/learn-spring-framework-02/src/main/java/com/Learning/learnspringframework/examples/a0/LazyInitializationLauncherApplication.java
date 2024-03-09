package com.Learning.learnspringframework.examples.a0;

import com.Learning.learnspringframework.game.GameConsole;
import com.Learning.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}
@Component
@Lazy
class ClassB{
    private final ClassA classA;

    ClassB(ClassA classA) {
        System.out.println("Class Initialized");
        this.classA = classA;
    }
    public void doSomething(){
        System.out.println("Do Something");
    }
}
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);
        System.out.println("Initialization of context is completed");
        context.getBean(ClassB.class).doSomething();
    }
}
