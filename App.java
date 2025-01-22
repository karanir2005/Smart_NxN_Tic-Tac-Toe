package project2;

import java.util.Scanner;

/**
 * Main method implementation for testing TicTacToe!
 * Rushil Karani
 * 11/28/2024
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to choose a game mode
        System.out.println("Pick a game mode: (1/2/3).");
        System.out.println("(1) Player vs Player");
        System.out.println("(2) Player vs Computer");
        System.out.println("(3) Computer vs Computer");

        int mode = 1;
        try {
            mode = scanner.nextInt();  // get mode input
            if (mode < 1 || mode > 3) {
                System.err.println("Select mode 1/2/3 only.");  // error for invalid mode
                mode=1;
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Invalid input. Selected Player vs Player.");  // default mode
        }

        // Ask user to pick grid size
        System.out.println("Pick grid size between 3-20 (default is 3):");
        int boardSize = 3;
        try {
            boardSize = scanner.nextInt();  // get board size input
            if (boardSize < 3 || boardSize > 20) {
                boardSize=3;
                System.err.println("Invalid, must be between 3-20");  // error for invalid size
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Selected default 3x3");  // default grid size
        }

        // Ask user to choose win condition
        System.out.println("Pick win condition (default is 3):");
        int winCondition = 3;
        try {
            winCondition = scanner.nextInt();  // get win condition input
            if (winCondition < 2 || winCondition > boardSize) {
                winCondition=3;
                System.err.println("Invalid, must be between 2 and board size");  // error for invalid win condition
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Selected default 3");  // default win condition
        }

        // Initialize players based on selected game mode
        Player player1 = new HumanPlayer("Player 1", 'X');
        Player player2 = new HumanPlayer("Player 2", 'O');
        
        if (mode == 1) {
            System.out.println("Player 1 is X and Player 2 is O.");
            player1 = new HumanPlayer("Player 1", 'X');
            player2 = new HumanPlayer("Player 2", 'O');
        } else if (mode == 2) {
            System.out.println("Player is X and Computer is O.");
            player1 = new HumanPlayer("Player", 'X');
            player2 = new ComputerPlayer("Computer", 'O');
        } else if (mode == 3) {
            System.out.println("Computer 1 is X and Computer 2 is O.");
            player1 = new ComputerPlayer("Computer 1", 'X');
            player2 = new ComputerPlayer("Computer 2", 'O');
        }

        // Create a new game with selected settings
        UpdatedGame game = new UpdatedGame(player1, player2, boardSize, winCondition);
        game.start();  // start the game

        scanner.close();  // close scanner
    }
}
