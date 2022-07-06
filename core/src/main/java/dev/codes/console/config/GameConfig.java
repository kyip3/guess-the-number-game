package dev.codes.console.config;

import dev.codes.console.GuessCount;
import dev.codes.console.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
//resources folder is at the classpath.
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==

    //default value is 20 if cannot find properties file
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    //default value is 5 if cannot find properties file
    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
