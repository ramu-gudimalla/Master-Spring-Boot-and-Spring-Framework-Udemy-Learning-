package com.Learning.learnspringframework;

import com.Learning.learnspringframework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
        context.getBean(GameConsole.class).up();
        context.getBean(GameRunner.class).run();
    }
}
