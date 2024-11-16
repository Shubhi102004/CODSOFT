import java.util.Random;
import java.util.Scanner;

public class GuessGame{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Guessing Game...!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; 
            int Attempts = 0;
            int maxAttempts = 10;
            boolean guessCorrectly = false;

            System.out.println("\nyou have to pick a number between 1 and 100...!");
            System.out.println("You have " + maxAttempts + " attempts to guess it...!");

            while (Attempts < maxAttempts && !guessCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                Attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number...!");
                    guessCorrectly = true;
                    score += (maxAttempts - Attempts + 1); 
                } else if (userGuess > numberToGuess) {
                    System.out.println("Guessed Number is Too high! Try again...!");
                } else {
                    System.out.println("Guessed Number is Too low! Try again...!");
                }
            }

            if (!guessCorrectly) {
                System.out.println("Sorry, you've used all of your attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + score);
        scanner.close();
    }
}
