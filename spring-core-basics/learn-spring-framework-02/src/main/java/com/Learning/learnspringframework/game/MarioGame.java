package com.Learning.learnspringframework.game;

import com.Learning.learnspringframework.game.GameConsole;
import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GameConsole {
    public void up(){
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("Go into the hole");
    }
    public void right(){
        System.out.println("Accelerate");
    }
    public void left(){
        System.out.println("Go back");
    }
}
