package src;

/**
 * The Tree class represents a tree in the Tents and Trees Puzzle.
 * It contains the x and y coordinates of the tree in the grid.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-13
 */
public class Tree {

    /**
     * @param x the x coordinate of the tree in the grid
     */
    private int x;
    /**
    * @param y the y coordinate of the tree in the grid
    */
    private int y;

    /**
     * Constructs a new Tree object with the given x and y coordinates.
     *
     * @param x the x coordinate of the tree in the grid
     * @param y the y coordinate of the tree in the grid
     */
    public Tree(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the tree in the grid.
     *
     * @return the x coordinate of the tree
     */
    public int getX(){
        return x;
    }

    /**
     * Returns the y coordinate of the tree in the grid.
     *
     * @return the y coordinate of the tree
     */
    public int getY() {
        return y;
    }


}
