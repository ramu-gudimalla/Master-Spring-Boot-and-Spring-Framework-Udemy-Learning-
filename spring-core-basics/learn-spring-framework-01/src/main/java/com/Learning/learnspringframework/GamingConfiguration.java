package com.Learning.learnspringframework;

import com.Learning.learnspringframework.game.GameConsole;
import com.Learning.learnspringframework.game.GameRunner;
import com.Learning.learnspringframework.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GameConsole gameConsole(){
        var gameConsole = new PacManGame();
        return gameConsole;
    }
    @Bean
    public GameRunner gameRunner(GameConsole gameConsole){
        var gameRunner = new GameRunner(gameConsole);
        return gameRunner;
    }
}
