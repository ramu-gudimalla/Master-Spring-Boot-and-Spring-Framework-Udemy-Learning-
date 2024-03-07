package com.Learning.learnspringframework.game;

import com.Learning.learnspringframework.game.GameRunner;
import com.Learning.learnspringframework.game.MarioGame;
import com.Learning.learnspringframework.game.PacManGame;
import com.Learning.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {
    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacManGame = new PacManGame(); // 1. object creation
        var gameRunner = new GameRunner(pacManGame);
        // 2. object creation + wiring of dependency
        // Game is a dependency of GameRunner
        gameRunner.run();


    }
}
