package project2;

/**
 * Updated Board class for NxN grids.
 */
public class UpdatedBoard extends Board {

    private int winCondition;  // condition for winning (e.g., 3 in a row)

    public UpdatedBoard(int size, int winCondition) {
        super(size);
        this.winCondition = winCondition;  // initialize win condition
    }

    public int getWinCondition() {
        return winCondition;  // return win condition
    }

    @Override
    public boolean checkWin(char marker) {
        int size = getSize();  // get grid size
        char[][] grid = getGrid();  // get game grid
        // check rows and columns for win condition
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - winCondition + 1; j++) {
                if (checkRow(grid, i, j, marker) || checkColumn(grid, i, j, marker)) return true;
            }
        }
        // check diagonals for win condition
        for (int i = 0; i < size - winCondition + 1; i++) {
            for (int j = 0; j < size - winCondition + 1; j++) {
                if (checkDiagonal(grid, i, j, marker)) return true;
            }
        }
        return false;  // no win
    }

    // check if there is a win in the row
    private boolean checkRow(char[][] grid, int row, int startCol, char marker) {
        int count = 0;
        for (int col = startCol; col < startCol + winCondition; col++) {
            count = (grid[row][col] == marker) ? count + 1 : 0;  // check marker in the row
            if (count == winCondition) return true;  // win condition met
        }
        return false;  // no win in this row
    }

    // check if there is a win in the column
    private boolean checkColumn(char[][] grid, int col, int startRow, char marker) {
        int count = 0;
        for (int row = startRow; row < startRow + winCondition; row++) {
            count = (grid[row][col] == marker) ? count + 1 : 0;  // check marker in the column
            if (count == winCondition) return true;  // win condition met
        }
        return false;  // no win in this column
    }

    // check if there is a win in the diagonals
    private boolean checkDiagonal(char[][] grid, int startRow, int startCol, char marker) {
        int count = 0;
        // check diagonal from top-left to bottom-right
        for (int i = 0; i < winCondition; i++) {
            if (startRow + i < getSize() && startCol + i < getSize() && grid[startRow + i][startCol + i] == marker) {
                count++;
                if (count == winCondition) return true;  // win condition met
            } else {
                break;  // no win in this diagonal
            }
        }
        count = 0;
        // check diagonal from bottom-left to top-right
        for (int i = 0; i < winCondition; i++) {
            if (startRow + i < getSize() && startCol - i >= 0 && grid[startRow + i][startCol - i] == marker) {
                count++;
                if (count == winCondition) return true;  // win condition met
            } else {
                break;  // no win in this diagonal
            }
        }
        return false;  // no win in either diagonal
    }
}
