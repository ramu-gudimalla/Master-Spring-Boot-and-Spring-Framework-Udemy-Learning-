package com.Learning.learnspringframework.examples.a0;

import com.Learning.learnspringframework.game.GameConsole;
import com.Learning.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.Learning.learnspringframework.examples.a0")
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class);

    }
}
