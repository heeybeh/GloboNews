package com.example.beatrice.globonews;

import java.util.Random;

public class RandomNumberGenerator {

    public int RandomGenerator() {
        Random random = new Random();
        int randomNum = random.nextInt(9);

        return randomNum;
    }

}