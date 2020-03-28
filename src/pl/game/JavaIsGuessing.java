package pl.game;

import java.util.Scanner;

public class JavaIsGuessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = 1000;
        int min = 0;
        int myNumber = 24;
        int countGuesses = 1;

        System.out.println("Think a number between 0 and 1000, " +
                "and I will guess it in a maximum of 10 attempts.");
        System.out.println("If you are ready, press \"yes\".");

        String inputValue = "";

        while (sc.hasNext()) {
            inputValue = sc.next();
            if (!inputValue.equals("yes")) {
                System.out.println("If you are ready, press \"yes\".");
            } else break;
        }

        inputValue = sc.nextLine();

        boolean victory = false;

        while (!victory) {

            int guess = checkGuess(max, min);
            System.out.println("Attempt " + countGuesses + " I'm guessing " + guess + "\n");
            countGuesses++;

            System.out.println("Select one of the option below:");
            int option = pickOption(sc);

            switch (option) {
                case 1:
                    if (guess == myNumber || countGuesses > 10) {
                        System.err.println("Do not cheat!" + "\n");
                    } else max = guess;
                    break;
                case 2:
                    if (guess == myNumber || countGuesses > 10) {
                        System.err.println("Do not cheat!" + "\n");
                    } else min = guess;
                    break;
                case 3:
                    System.out.println("Who is the winner ? I AM !!");
                    victory = true;
            }
        }
    }

    public static int checkGuess(int max, int min) {
        return min + ((max - min) / 2);
    }

    public static int pickOption(Scanner sc) {
        System.out.println("1 - Too much");
        System.out.println("2 - Not enough");
        System.out.println("3 - You guessed !");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("You must to select 1, 2, or 3");
        }
        int option = sc.nextInt();
        while (option != 1 && option != 2 && option != 3) {
            option = sc.nextInt();
            System.out.println("You must to select 1, 2, or 3");
        }
        return option;
    }
}