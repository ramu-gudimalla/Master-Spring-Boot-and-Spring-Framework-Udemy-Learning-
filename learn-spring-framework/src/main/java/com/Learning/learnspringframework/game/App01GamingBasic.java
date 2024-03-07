package com.Learning.learnspringframework.game;

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
