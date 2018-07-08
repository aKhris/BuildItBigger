package com.akhris.javajoker;

import java.util.Random;

public class JavaJoker {

    private static final String[] jokesArray =
            new String[]{
             "Helvetica and Times New Roman walk into a bar. \"Get out of here!\" shouts the bartender. \"We don`t serve your type.",
                  "Hear about the new restaurant called Karma?\nThere’s no menu: You get what you deserve.",
                    "Did you hear about the claustrophobic astronaut?\nHe just needed a little space.",
                    "How do you drown a hipster?\nThrow him in the mainstream.",
                    "What did the left eye say to the right eye?\nBetween you and me, something smells.",
                    "What did the buffalo say when his son left for college?\nBison.",
                    "What is an astronaut’s favorite part on a computer?\nThe space bar.",
                    "Why did the yogurt go to the art exhibition?\nBecause it was cultured.",
                    "Why did the hipster burn his mouth?\nHe drank the coffee before it was cool."
            };

    public String getRandomJoke(){
        Random ran = new Random();
        int jokeIndex = ran.nextInt(jokesArray.length);
        return jokesArray[jokeIndex];
    }
}
