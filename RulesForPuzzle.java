/**
 * The RulesForPuzzle class contains methods to check the rules of the Tents and Trees Puzzle game.
 * The puzzle rules are:
 * 1. Each tree should have precisely one tent next to it, either horizontally or vertically.
 * 2. Each tent is attached to one tree (so there are as many tents as trees). A tree might be
 * next to two tents but is only connected to one.
 * 3. Tents cannot be placed adjacent, horizontally, vertically, or diagonally.
 * 4. The grid can contain pre-placed tents that must be considered when solving the puzzle.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-13
 */

package src;

public class RulesForPuzzle {

    /**
     * @param grid is the 2D array representing the grid of the game
     */
    private char[][] grid;

    /**
     * @param placedTents is the 2D boolean array keep a tent has been placed in a given cell of the puzzle grid.
     */
    private boolean[][] placedTents;

    /**
     * @param trees is the queue of trees in the game.
     */
    private Queue<int[]> trees;

    /**
     * @param tents is the queue of tents in the game.
     */
    private Queue<int[]> tents;

    /**
     * @param n is the number of rows in the puzzle grid.
     */
    private int n;

    /**
     * @param m is the number of columns in the puzzle grid.
     */
    private int m;

    /**
     * Constructs with the given number of rows and columns for the puzzle grid.
     *
     * @param row is the number of rows in the puzzle grid
     * @param col is the number of columns in the puzzle grid
     */
    public RulesForPuzzle(int row, int col ,char[][] grid) {
        this.grid = grid;
        this.placedTents = new boolean[row][col];
        this.trees = new Queue<>();
        this.tents = new Queue<>();
        this.n = row;
        this.m = col;
    }


    /**
     * Checks whether there is a contiguous tents in the puzzle grid at the provided row and column indices.
     *
     * @param row the row index
     * @param col the column index
     * @return true if there is a contiguous tents at the given indices, false otherwise
     */

    public boolean isAdjacentToTents(int row, int col) {
        if(isValidCor(row-1, col) && grid[row-1][col] == 'X') {
            return true;
        }else if (isValidCor(row-1, col+1) && grid[row-1][col+1] == 'X'){
            return true;
        }else if (isValidCor(row, col+1) && grid[row][col+1] == 'X'){
            return true;
        }else if (isValidCor(row+1, col+1) && grid[row+1][col+1] == 'X'){
            return true;
        }else if (isValidCor(row+1, col) && grid[row+1][col] == 'X'){
            return true;
        }else if (isValidCor(row+1, col-1) && grid[row+1][col-1] == 'X'){
            return true;
        }else if (isValidCor(row-1, col) && grid[row-1][col] == 'X'){
            return true;
        }else if (isValidCor(row-1, col-1) && grid[row-1][col-1] == 'X'){
            return true;
        }

        return false;
    }

    /**
     * Determines whether the provided row and column indices are valid and match within the puzzle grid.
     *
     * @param row is the row index
     * @param col is the column index
     * @return true if the indices are valid and match within the puzzle grid, false otherwise
     */
    public boolean isValidPlacement(int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        } else if (isAdjacentToTents(row, col)) {
            return false;
        }
        return true;
    }

    public boolean isValidCor(int row, int col) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length);
    }

    /**
     * Checks whether the tent placement in the puzzle grid is valid according to the puzzle rules.
     *
     * @param grid is the puzzle grid
     * @return true if the tent placement is valid according to the puzzle rules, false otherwise
     */
    public boolean isValidTentPlacement(char[][] grid){

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 'X' && !isValidPlacement(i, j)) {
                    return false;
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    if (isAdjacentToTents(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }





}
