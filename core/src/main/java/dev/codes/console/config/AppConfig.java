package dev.codes.console.config;


import dev.codes.console.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//specify that this class is a configuration class. For main()
//scan the whole packages for annotated classes (@Component), add into the beans
@Configuration
@Import(GameConfig.class) //import another config class to this class
@ComponentScan(basePackages = "dev.codes")
public class AppConfig {

    //class with no @Component, we have to manually create a bean so that spring can manage
    //asking the bean to manage the below objects for us
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
