package dev.codes.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == field ==

    @Autowired
    private NumberGenerator numberGenerator;
    @Autowired
    @GuessCount
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        this.smallest = numberGenerator.getMinNumber();
        this.guess = numberGenerator.getMinNumber();
        this.remainingGuesses = guessCount;

        //this number generator is null
        //we need to do a constructor injection using beans (using constructor)
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in game preDestroy()");
    }
    // == public method ==

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }


    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {

            log.info("is valid range..");
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }

            log.info("biggest is {} smallest is {}", biggest,smallest);
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {

        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
