package com.Learning.learnspringframework.game;

import com.Learning.learnspringframework.game.GameConsole;

public class SuperContraGame implements GameConsole {
    public void up(){
        System.out.println("Up");
    }
    public void down(){
        System.out.println("Crunch");
    }
    public void right(){
        System.out.println("Shoot a bullet");
    }
    public void left(){
        System.out.println("Go back");
    }
}
