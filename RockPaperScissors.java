import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            
            System.out.println("Computer chose: " + computerChoice);
            
            int result = getGameResult(userChoice, computerChoice);
            
            if (result == 0) {
                System.out.println("It's a tie!");
            } else if (result == 1) {
                System.out.println("Congratulations! You win!");
            } else {
                System.out.println("Sorry! You lose!");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Thank you for playing. Goodbye!");
        scanner.close();
    }
    
    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
    
    private static int getGameResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return 0; // Tie
        } else if (
            (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return 1; // User wins
        } else {
            return -1; // Computer wins
        }
    }
}
