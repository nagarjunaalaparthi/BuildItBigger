package com.udacity.jokesjavalib;

import java.util.Random;

public class Joker {

    private final String[] JOKES = {
            "If debugging is the process of removing software bugs, then programming must be the process of putting them in.",
            "Why did the developer go broke? \n Because he used up all his cache",
            "Why do Java developers wear glasses? Because they can't C#",
            "A good programmer is someone who always looks both ways before crossing a one-way street.",
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect.\""
    };

    /**
     * get a random joke.
     */
    public String getJoke() {
        Random rand = new Random();
        return JOKES[rand.nextInt(JOKES.length)];
    }
}
