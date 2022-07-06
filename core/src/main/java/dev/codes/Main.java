package dev.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        log.info("Guess the number game");
        log.info("logging module successfully imported!!");

        // create context (container)
        // ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //if assigned a name, then the @component need to explictly specify too. @Component("numberGenerator")
        //NumberGenerator numberGenerator = context.getBean("numberGenerator",NumberGenerator.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("number = {}",number);

        // get game bean from context
        Game game = context.getBean(Game.class);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("get main message = {}",messageGenerator.getMainMessage());
        log.info("get result message = {}",messageGenerator.getResultMessage());
        //game.reset();
        // to prevent memory loss
        context.close();
    }
}
