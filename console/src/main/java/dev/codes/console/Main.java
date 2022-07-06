package dev.codes.console;

import dev.codes.console.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        log.info("Guess the number game");
        log.info("logging module successfully imported!!");

        // create context (container)
        // ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // close context
        // to prevent memory loss
        context.close();
    }
}
