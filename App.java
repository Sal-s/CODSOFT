import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;

            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            
            System.out.println("\nRound " + roundsPlayed + " - Guess the number between " + lowerLimit + " and " + upperLimit);

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempts.");
                    totalAttempts += attempt;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Game Over. You played " + roundsPlayed + " rounds with an average of " + (double) totalAttempts / roundsPlayed + " attempts per round.");

        scanner.close();
    }
}
