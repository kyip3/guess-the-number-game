package dev.codes.console.config;

import dev.codes.console.GuessCount;
import dev.codes.console.MaxNumber;
import dev.codes.console.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.validation.annotation.Validated;



@Configuration
@ComponentScan(basePackages = "dev.codes")
@PropertySource("classpath:config/game.properties") //resources folder is at the classpath.
public class GameConfig {

    // == fields ==

    //default value is 20 if cannot find properties file
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    //default value is 5 if cannot find properties file
    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:3}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
