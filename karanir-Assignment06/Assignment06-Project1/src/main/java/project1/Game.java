package project1;

/**
 * Game class
*/

import java.util.Scanner;

public class Game {
    protected Board board;  // game board
    protected Player player1; 
    protected Player player2;  

    public Game(Player player1, Player player2, int size) {
        this.board = new Board(size);  // initialize board
        this.player1 = player1; 
        this.player2 = player2; 
    }

    public void start() {
        Player currentPlayer = player1;  // start with player1
        boolean game_over = false;  // to track game status

        // main game loop
        while (!game_over) {
            board.display();  // show current board
            int[] move = currentPlayer.getMove(board);  // get move from player
            
            // handle player's move
            if (board.placeMarker(move[0], move[1], currentPlayer.getMarker())) {  
                // check if player wins
                if (board.checkWin(currentPlayer.getMarker())) {
                    board.display();  
                    System.out.println(currentPlayer.getName() + " wins!");  
                    game_over = true;
                } 
                // check for draw
                else if (board.isFull()) {
                    board.display();  
                    System.out.println("It's a draw!");  
                    game_over = true; 
                } 
                // switch to the next player
                else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } 
            else {
                // handle invalid move
                System.err.println("Invalid move. Cell already occupied or out of bounds. Try again.");
            }
        }
        promptRestart();  // ask if players want to restart
    }

    // prompt to restart the game
    public void promptRestart() {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Do you want to play again? (yes/no): "); 
        
        String response = scanner.nextLine();  
        // handle restart or exit
        if (response.equalsIgnoreCase("yes")) {
            //start new game.
            Game reGame = new Game(player1, player2, board.getSize());  
            reGame.start();  
        } 
        else {
            System.out.println("Thank you for playing!"); 
            scanner.close();  
        }
    }
}
