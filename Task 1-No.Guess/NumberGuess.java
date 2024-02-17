import java.util.Scanner;
import java.util.Random;

class Game {
    public int number;
    public int attempts;
    public  int max_attempts = 5;

    public Game() {
        Random rand = new Random();

        // Generate random number between 1 and 100
        number = rand.nextInt(100) + 1; 
        attempts = 0;
    }



    public void play() {
        Scanner sc = new Scanner(System.in);

        while (attempts < max_attempts) {
            System.out.print("\nEnter your guess between 1 and 100: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Tumera number chota hai Bada number likho.");
            } else if (guess > number) {
                System.out.println("Tumera number bada hai Chota number likho.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + number + " correctly in " + attempts + " attempts!");
                return;
            }
        }

        System.out.println("Sorry, you've used all your attempts. The correct number was " + number + ".");
    }
}

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number game!");

        // play Again
        while (playAgain) {
            Game game = new Game();
            game.play();


            System.out.print("\nDo you want to play again? ( Yes / No): ");
            String playAgainInput = sc.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Khalna k liya  dannyWad ( Thanks for Playing the Game!).");
        sc.close();
    }
}
