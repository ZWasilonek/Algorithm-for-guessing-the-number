package pl.game;

import java.util.Scanner;

public class JavaIsGuessing {

    public static void main(String[] args) {

        System.out.println("Think of a number from 0 to 1000, " +
                "and I will guess it in maximum 10 attempts");
        System.out.println("If you are ready, press \"yes\".");
        int min = 0;
        int max = 1000;
        Scanner scanner = new Scanner(System.in);

        String inputValue = "";

        while (scanner.hasNext()) {
            inputValue = scanner.next();
            if (!inputValue.equals("yes")) {
                System.out.println("If you are ready, press \"yes\".");
            } else break;
        }

        inputValue = scanner.nextLine();

        for (int i = 1; i <= 10; ) {
            int guess = (max - min) / 2 + min;
            System.out.println("Attempt " + i + ". I am guessing: " + guess);
            System.out.println("Press \"not enough\", \"too much\" or \"you guessed\"");

            String line = scanner.nextLine();
            if (line.equals("You guessed")) {
                System.out.println("I am the winner !");
                break;
            } else if (line.equals("too much")) {
                max = guess;
                i++;
            } else if (line.equals("not enough")) {
                min = guess;
                i++;
            } else {
                System.out.println("Do not cheat!");
            }
        }

    }

}