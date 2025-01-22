package project1;

import java.util.Scanner;

/**
 * Human Player class
*/

public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);  // scanner for user input

    public HumanPlayer(String name, char marker) {
        super(name, marker);  // initialize player with name and marker
    }

    @Override
    public int[] getMove(Board board) {
        System.out.println(getName() + ", enter your move (row and column eg. 1 2): ");

        int row = -1, col = -1;

        try {
            row = scanner.nextInt();  // get row input
            col = scanner.nextInt();  // get column input
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Enter 2 numbers: row and column eg. 1 2");
            scanner.nextLine();  // clear invalid input
        }

        int[] move = {row - 1, col - 1}; // adjust input for 0-indexed array
        return move;
    }
}
