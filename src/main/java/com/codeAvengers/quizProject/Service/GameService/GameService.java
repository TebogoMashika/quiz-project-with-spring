package com.codeAvengers.quizProject.Service.GameService;

import com.codeAvengers.quizProject.Repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // THIS PART GENERATES THE 5 RANDOM NUMBERS FOR THE GAME PIN..

    //Referenced from https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
    int gamePin = getRandomInt(100000, 10000);
    //System.out.println("Your game pin is: " + gamePin);

    /* * returns random integer between minimum and maximum range */
    public static int getRandomInt(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }
}
