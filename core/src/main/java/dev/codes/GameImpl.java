package dev.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == field ==

    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // == constructors ==
    // to pass in the number generator object (constructor injection using beans)
    // commented off to use getter/setter injection
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    // == public method ==
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    @Override
    public void reset() {
        this.smallest = 0;
        this.guess = 0;
        this.remainingGuesses = guessCount;

        //this number generator is null
        //we need to do a constructor injection using beans (using constructor)
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

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
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
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
