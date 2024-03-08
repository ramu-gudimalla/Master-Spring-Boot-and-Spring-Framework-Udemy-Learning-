package com.Learning.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GameConsole game;
    public GameRunner(@Qualifier("pacManGame") GameConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game "+ game);
        game.right();
        game.down();
        game.left();
        game.up();
    }
}
