package org.example;

import java.util.Scanner;

public class BullsAndCowsGame {

    private int[] secretNumber;
    private int numberLength;
    private boolean gameWon;

    public BullsAndCowsGame(int numberLength) {

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
}
