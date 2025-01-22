package project1;

/**
 * Board class representing the game board for Tic-Tac-Toe.
 */
public class Board {

    private char[][] grid;  // 2D array to represent the board grid
    private int size;  // size of the board (NxN)

    // Constructor to initialize the board with the given size
    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        initialize();  // initialize the grid with empty spaces
    }

    // Initialize the grid with empty spaces
    public void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';  // set each cell to empty (' ')
            }
        }
    }

    // Get the size of the board
    public int getSize() {
        return size;
    }

    // Get the grid representing the board
    public char[][] getGrid() {
        return grid;
    }

    // Place the marker on the board if the cell is empty
    public boolean placeMarker(int x, int y, char marker) {
        if (checkCell(x, y)) {
            grid[x][y] = marker;  // place the marker on the board
            return true;
        }
        return false;  // return false if the cell is already occupied
    }

    // Check if a given cell is empty and within bounds
    public boolean checkCell(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == ' ');
    }

    // Display the current state of the board
    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(" " + grid[i][j] + " ");  // print the cell value
                if (j < grid[i].length - 1) {
                    System.out.print("|");  // print the vertical separator
                }
            }
            System.out.println();
            if (i < grid.length - 1) {
                // Print horizontal separator between rows
                for (int j = 0; j < size; j++) {
                    System.out.print("----");
                }
                System.out.println();
            }
        }
        System.out.println();  // print a new line at the end
    }

    // Check if there is a winner on the board
    public boolean checkWin(char marker) {
        return checkRowsAndCols(marker) || checkDiagonals(marker);
    }

    // Check if any row or column has all the same marker
    private boolean checkRowsAndCols(char marker) {
        for (int i = 0; i < size; i++) {
            // Check each row and each column
            if (checkLine(marker, i, 0, 0, 1) || checkLine(marker, 0, i, 1, 0)) {
                return true;
            }
        }
        return false;
    }

    // Check if either diagonal has all the same marker
    private boolean checkDiagonals(char marker) {
        return checkLine(marker, 0, 0, 1, 1) || checkLine(marker, 0, size - 1, 1, -1);
    }

    // Check if a specific line (row, column, or diagonal) has all the same marker
    private boolean checkLine(char marker, int start_row, int start_col, int row_inc, int col_inc) {
        for (int i = 0; i < size; i++) {
            if (grid[start_row][start_col] != marker) {  // if the current cell does not match the marker
                return false;
            }
            start_row += row_inc;  // increment the row index
            start_col += col_inc;  // increment the column index
        }
        return true;  // return true if the entire line matches the marker
    }

    // Check if the board is full (no empty cells left)
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == ' ') {  // if any cell is empty
                    return false;  // the board is not full
                }
            }
        }
        return true;  // return true if all cells are filled
    }
}
