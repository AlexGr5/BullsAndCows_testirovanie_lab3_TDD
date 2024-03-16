package org.example;

import java.util.Scanner;

public class BullsAndCowsGame {

    private int[] secretNumber;
    private int numberLength;
    private boolean gameWon;

    public BullsAndCowsGame(int numberLength) {
        this.secretNumber = generateGuessNumber(numberLength);
        this.numberLength = numberLength;
        this.gameWon = false;
    }

    public BullsAndCowsGame() {
        this.secretNumber = generateGuessNumber(choiceLevel());
        this.numberLength = secretNumber.length;
        this.gameWon = false;
    }

    public int choiceLevel() {
        int guess = 0;
        Scanner scanner = new Scanner(System.in);
        boolean flagChoice = false;

        while (!flagChoice) {
            System.out.println("\nDifficulty level (length of the guessed number):");
            System.out.println("3 - Easily");
            System.out.println("4 - Normal");
            System.out.println("5 - Hard");
            System.out.println("6 - Unreal");
            System.out.print("Select number: ");

            guess = scanner.nextInt();

            if (guess >= 3 && guess <= 6)
                flagChoice= true;
            else
                System.out.println("\nInput error! Choice correct number!");
        }

        return guess;
    }

    public int[] generateGuessNumber(int length) {
        int i, j;
        int tmp = 0;
        int fl;
        int count;
        int[] number = new int[length];

        for (i = 0; i < length; i++) {
            if (i == 0) {
                tmp = (int) (1 + Math.random() * 9);
            }
            else {
                fl = 1;
                tmp = (int) (Math.random() * 10);
                while (fl == 1) {
                    count = 0;
                    for (j = 0; j < i; j++) {
                        if ((number[j]) == tmp) {
                            count++;
                        }
                    }
                    if (count > 0)
                        tmp = (int) (Math.random() * 10);
                    else
                        fl = 0;
                }
            }
            number[i] = tmp;
        }

        return number;
    }

    public int[] getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int[] secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int[] getResult(int[] guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == secretNumber[i]) {
                bulls++;
            } else {
                for (int j = 0; j < secretNumber.length; j++) {
                    if (guess[i] == secretNumber[j]) {
                        cows++;
                        break;
                    }
                }
            }
        }
        return new int[]{bulls, cows};
    }

}
