package src;

/**
 * The TentsAndTreesPuzzle class represents a Tents and Trees puzzle game.
 * It contains the grid, the size of the grid, the trees and the tents in the game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-13
 */

public class TentsAndTreesPuzzle {
    /**
     * @param grid is the 2D array representing the grid of the game
     */
    private char[][] grid;

    /**
     * @param trees is the queue of trees in the game.
     * <p>
     * The x and y coordinates of the tree can be accessed using the getX() and getY() methods of the Tree class.
     */
    private Queue<Tree> trees;

    /**
     * @param tents is the queue of tents in the game.
     * <p>
     * The x and y coordinates of the tents can be accessed using the getX() and getY() methods of the Tents class.
     */
    private Queue<Tents> tents;

    private RulesForPuzzle rules;

    /**
     * Constructs a new TentsAndTreesPuzzle object with the given grid.
     *
     * @param grid   is the 2D array representing the grid of the game
     * @param rules1
     */
    public TentsAndTreesPuzzle(char[][] grid, RulesForPuzzle rules1) {
        this.rules = rules1;
        this.grid = grid;
        this.trees = new Queue<>();
        this.tents = new Queue<>();
    }


    /**
     * Solves the Tents and Trees puzzle and returns true if a solution is found.
     *
     * @return true if a valid solution is found, false otherwise
     */
    public char[][] solvingPuzzle() {

        trees = new Queue<Tree>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    trees.enqueue(new Tree(i, j));
                }
            }
        }

        tents = new Queue<Tents>();
        for (int i = 0; i < trees.size(); i++) {
            tents.enqueue(null);
        }

        while (!trees.isEmpty()) {
            Tree currentTrees = trees.getFirst().getData();
            Tents currentTents = tents.getFirst().getData();

            if(currentTents == null){
                currentTents = findValidTent(currentTrees);
            }
            if(currentTents != null){
                grid[currentTents.getX()][currentTents.getY()] = 'X';
            }

            currentTrees = trees.dequeue().getData();
            currentTents = tents.dequeue().getData();


        }
        return grid;
    }

    private Tents findValidTent(Tree tree){
        int x = tree.getX();
        int y = tree.getY();
        if(y+1 < grid[0].length && grid[x][y+1] == '0' && rules.isValidPlacement(x,y+1) == true) {
            return new Tents(x, y + 1);
        }
        else if (y-1 >= 0 && grid[x][y-1] == '0' && rules.isValidPlacement(x,y-1) == true) {
            return new Tents(x, y - 1);
        }
        else if (x-1 >= 0 && grid[x-1][y] == '0' && rules.isValidPlacement(x-1,y) == true) {
            return new Tents(x-1, y);
        }
        else if (x+1 < grid.length && grid[x+1][y]== '0' && rules.isValidPlacement(x+1,y) == true) {
            return new Tents(x+1, y);
        }
    return null;
    }


}



