package src;

/**
 * The Tents class represents a tent in the Tents and Trees Puzzle.
 * It contains the x and y coordinates of the tent in the grid.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-13
 */
public class Tents {
    private int x;
    private int y;

    /**
     * Constructs a new Tents object with the given x and y coordinates.
     *
     * @param x the x coordinate of the tent in the grid
     * @param y the y coordinate of the tent in the grid
     */
    public Tents(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the tent in the grid.
     *
     * @return the x coordinate of the tent
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the tent in the grid.
     *
     * @return the y coordinate of the tent
     */
    public int getY() {
        return y;
    }


}
