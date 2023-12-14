import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = getRandomNumber(minRange, maxRange);
            int attempts = 0;

            System.out.println("\nI've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                int userGuess = getUserGuess(scanner, minRange, maxRange);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);

        } while (playAgain(scanner));

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }

    private static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private static int getUserGuess(Scanner scanner, int min, int max) {
        int userGuess;
        do {
            System.out.print("Enter your guess (" + min + " - " + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            userGuess = scanner.nextInt();
        } while (userGuess < min || userGuess > max);

        return userGuess;
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes");
    }
}

