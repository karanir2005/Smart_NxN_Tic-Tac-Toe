package project2;

/**
 * Updated Game class for NxN grids
*/

import java.util.Scanner;

public class UpdatedGame extends Game {
    private UpdatedBoard board;

    public UpdatedGame(Player player1, Player player2, int size, int winCondition) {
        super(player1, player2, size);
        this.board = new UpdatedBoard(size, winCondition); //updates board to a UpdatedBoard object so it can store win condition.
    }

    @Override
    public void start() {
        Player currentPlayer = player1;
        boolean game_over = false;

        while (!game_over) {
            board.display();
            int[] move = currentPlayer.getMove(board);
            
            if (board.placeMarker(move[0], move[1], currentPlayer.getMarker())) {
                if (board.checkWin(currentPlayer.getMarker())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    game_over = true;
                } 
                else if (board.isFull()) {
                    board.display();
                    System.out.println("It's a draw!");
                    game_over = true;
                } 
                else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } 
            else {
                System.err.println("Invalid move. Cell already occupied or out of bounds. Try again.");
            }
        }
        promptRestart();
    }

    @Override
    public void promptRestart() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Do you want to play again? (yes/no): ");
        
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            UpdatedGame reGame = new UpdatedGame(player1, player2, board.getSize(), board.getWinCondition());
            reGame.start();
        } 
        else {
            System.out.println("Thank you for playing!");
            scanner.close();
        }
    }
}