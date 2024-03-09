package com.Learning.learnspringframework.xml_configuration;

import com.Learning.learnspringframework.game.GameRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        context.getBean(GameRunner.class).run();
    }
}
