package com.rbhatt.numbergame;

import java.util.Random;
import java.util.Scanner;

// program will generate a 4 digit random number and the user will have to guess in 10 tries
// for each guess, the program will tell the user how many numbers are present in the random number and how many are in the correct location.
// the program will then tell the user if the guess is correct.
// the program will then exit.

public class NumberGame {
    public String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String randomNumberStr = Integer.toString(randomNumber);
        return randomNumberStr;
    }

    public boolean guessNumber(String guess, String randomNumber) {
        if (guess.equals(randomNumber)) {
            System.out.println("You guessed the number!");
            return true;
        } 

        char[] guessChars = guess.toCharArray();
        char[] randomNumberChars = randomNumber.toCharArray();

        int numbersPresent = 0;

        for (int i = 0; i < guessChars.length; i++) {
            if (randomNumber.contains(String.valueOf(guessChars[i]))) {
                numbersPresent++;
            }
        }

        int correctLocations = 0;
        for (int i = 0; i < randomNumberChars.length; i++) {
            if (guessChars[i] == randomNumberChars[i]) {
                correctLocations++;
            }
        }

        System.out.println("Numbers present: " + numbersPresent);
        System.out.println("Correct locations: " + correctLocations);

        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Generating random number...");
        NumberGame numberGame = new NumberGame();
        String randomNumber = numberGame.generateRandomNumber();
        
        System.out.print("Enter your guess (0000-9999): ");

        for (int i = 0; i < 10; i++) {
            boolean isGuessRight = false;
            String guess = scanner.nextLine();
            isGuessRight =numberGame.guessNumber(guess, randomNumber);
            if (isGuessRight) {
                break;
            }
        }
        
        System.out.println("The number was: " + randomNumber);
        
        scanner.close();
    }
}