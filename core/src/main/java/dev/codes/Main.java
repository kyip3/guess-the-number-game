package dev.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args)
    {
        log.info("Guess the number game");
        log.info("logging module successfully imported!!");

        // create context (container)
        // ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator",NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("number = {}",number);

        // get game bean from context
        Game game = context.getBean(Game.class);

        //game.reset();
        // to prevent memory loss
        context.close();
    }
}
