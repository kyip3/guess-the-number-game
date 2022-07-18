package dev.codes.service;

import dev.codes.console.Game;
import dev.codes.console.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    //private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public GameServiceImpl( Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

//    @PostConstruct
//    public void init(){
//
//        log.info("in Game Service Implementation");
//        log.info("getting main message {}", getMainMessage());
//        checkGuess(66);
//
//        log.info("getting number to guess {}", game.getNumber());
//    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
