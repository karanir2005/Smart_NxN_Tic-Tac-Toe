package project2;

import java.util.Random;

/**
 * Computer Player class
 */
public class ComputerPlayer extends Player {

    // Constructor to initialize the computer player with a name and marker
    public ComputerPlayer(String name, char marker) {
        super(name, marker);
    }

    // Override method to get the computer player's move
    @Override
    public int[] getMove(Board board) {
        Random random = new Random();

        int size = board.getSize();  // Get the size of the board
        int row, col;

        // Loop until a valid (empty) cell is found
        do {
            row = random.nextInt(size);  // Generate a random row
            col = random.nextInt(size);  // Generate a random column
        } while (!board.checkCell(row, col));  // Check if the generated cell is empty

        // Try to make a strategic move if possible
        int[] best_move = bestMove(board);

        // If a strategic move is found, override the random choice
        if (best_move != null) {
            row = best_move[0];
            col = best_move[1];
        }

        // Return the selected row and column as the move
        return new int[]{row, col};
    }

    // Method to determine the best move based on priority strategies
    private int[] bestMove(Board board) {
        char grid[][] = board.getGrid();  // Get the board grid
        int size = board.getSize();  // Get the board size
        char rival_marker = (getMarker() == 'X') ? 'O' : 'X';  // Determine the opponent's marker

        // Prioritize winning
        for (int i = 0; i < size; i++) {

            int count = 0;
            int empty = -1;

            // Check horizontal line for a winning move
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == getMarker()) {
                    count++;  // Count the current player's markers
                }
                if (board.checkCell(i, j)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (count == 2 && empty != -1) {
                return new int[]{i, empty};  // Return the winning move if found
            }

            count = 0;
            empty = -1;

            // Check vertical line for a winning move
            for (int j = 0; j < size; j++) {
                if (grid[j][i] == getMarker()) {
                    count++;  // Count the current player's markers
                }
                if (board.checkCell(j, i)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (count == 2 && empty != -1) {
                return new int[]{empty, i};  // Return the winning move if found
            }

            count = 0;
            empty = -1;

            // Check diagonal (top-left to bottom-right) for a winning move
            if (grid[i][i] == getMarker()) {
                count++;  // Count the current player's markers
            }
            if (board.checkCell(i, i)) {
                empty = i;  // Track the empty cell
            }
            if (count == 2 && empty != -1) {
                return new int[]{i, i};  // Return the winning move if found
            }

            count = 0;
            empty = -1;

            // Check diagonal (top-right to bottom-left) for a winning move
            for (int j = size - 1; j >= 0; j--) {
                if (grid[i][j] == getMarker()) {
                    count++;  // Count the current player's markers
                }
                if (board.checkCell(i, j)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (count == 2 && empty != -1) {
                return new int[]{i, empty};  // Return the winning move if found
            }
        }

        // Block the opponent from winning
        for (int i = 0; i < size; i++) {

            int rival_count = 0;
            int empty = -1;

            // Check horizontal line to block the opponent
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == rival_marker) {
                    rival_count++;  // Count the opponent's markers
                }
                if (board.checkCell(i, j)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (rival_count == 2 && empty != -1) {
                return new int[]{i, empty};  // Block the opponent's winning move
            }

            rival_count = 0;
            empty = -1;

            // Check vertical line to block the opponent
            for (int j = 0; j < size; j++) {
                if (grid[j][i] == rival_marker) {
                    rival_count++;  // Count the opponent's markers
                }
                if (board.checkCell(j, i)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (rival_count == 2 && empty != -1) {
                return new int[]{empty, i};  // Block the opponent's winning move
            }

            rival_count = 0;
            empty = -1;

            // Check diagonal (top-left to bottom-right) to block the opponent
            if (grid[i][i] == rival_marker) {
                rival_count++;  // Count the opponent's markers
            }
            if (board.checkCell(i, i)) {
                empty = i;  // Track the empty cell
            }
            if (rival_count == 2 && empty != -1) {
                return new int[]{i, i};  // Block the opponent's winning move
            }

            rival_count = 0;
            empty = -1;

            // Check diagonal (top-right to bottom-left) to block the opponent
            for (int j = size - 1; j >= 0; j--) {
                if (grid[i][j] == rival_marker) {
                    rival_count++;  // Count the opponent's markers
                }
                if (board.checkCell(i, j)) {
                    empty = j;  // Track the empty cell
                }
            }
            if (rival_count == 2 && empty != -1) {
                return new int[]{i, empty};  // Block the opponent's winning move
            }
        }

        // Play in the center if available
        if (board.checkCell(size / 2, size / 2)) {
            return new int[]{size / 2, size / 2};
        }

        // Play in one of the corners if available
        if (board.checkCell(0, 0)) {
            return new int[]{0, 0};
        } else if (board.checkCell(0, size - 1)) {
            return new int[]{0, size - 1};
        } else if (board.checkCell(size - 1, 0)) {
            return new int[]{size - 1, 0};
        } else if (board.checkCell(size - 1, size - 1)) {
            return new int[]{size - 1, size - 1};
        }

        // If no best move is found, return null
        return null;
    }
}
