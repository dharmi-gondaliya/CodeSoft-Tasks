import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("\nWelcome to the Number Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (guess == targetNumber) {
                    System.out.println("\nCongratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("\nYour score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("Thank you for playing the Number Game!");
        scanner.close();
    }
}
