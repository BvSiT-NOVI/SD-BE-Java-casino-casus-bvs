package novi.higherlower;

import java.util.Scanner;

public class HigherLowerGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;
        int numGamesPlayed=0;
        // Here you should generate the number to guess

        while (gameIsRunning) {
            numGamesPlayed++;
            int input=0;
            int random  = (int)(Math.random()*100);
            System.out.println("Make a guess");

            //https://stackoverflow.com/questions/2496239/how-do-i-keep-a-scanner-from-throwing-exceptions-when-the-wrong-type-is-entered
            while(true){
                if (inputScanner.hasNextInt()) {
                    input = inputScanner.nextInt() ;
                    break;
                } else {
                    System.out.println("Sorry, couldn't understand you!");
                    inputScanner.next();//clear
                }
            }

            System.out.printf("You typed: %s\n", input);

            //var input = inputScanner.nextLine();

            if (input==random){
                String msg = "%d is correct! You guessed the number in %d turns";
                System.out.println(String.format(msg,random,numGamesPlayed));
                gameIsRunning=false;
                break;
            }
            else {
                if (input > random) {
                    System.out.println("That number is too high");
                } else {
                    System.out.println("That number is too low");
                }
            }
            // Check if the guess is correct, if so end the game
        }
    }
}
