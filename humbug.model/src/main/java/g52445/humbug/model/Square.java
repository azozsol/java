package g52445.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it’s all. A square doesn’t know where it is on the board.
 *
 * @author solimanazoz
 */
public class Square {

    private SquareType type;
    private boolean northWall;
    private boolean southWall;
    private boolean westWall;
    private boolean eastWall;

    /**
     * Constructor of Square on board.
     *
     * @param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
        this.northWall = false;
        this.southWall = false;
        this.westWall = false;
        this.eastWall = false;
    }

    /**
     * Simple constructor for readign Jackson's fiels
     */
    public Square() {
    }

    /**
     * Simple getter of type.
     *
     * @return type of Square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * Simple setter of type
     *
     * @param type
     */
    public void setType(SquareType type) {
        this.type = type;
    }

    /**
     * Simple setter northWal
     *
     * @param northWall
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Simple setter for southWall
     *
     * @param southWall
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Simple setter for westWall
     *
     * @param westWall
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Simple setter for eastWall
     *
     * @param eastWall
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    /**
     * Chacking if there is wall or not in certein direction;
     *
     * @param direction 4 kinds of direction
     * @return true if there is wall , false otherwise
     */
    public boolean hasWall(Direction direction) {
        switch (direction) {
            case NORTH:
                return this.northWall;
            case SOUTH:
                return this.southWall;
            case WEST:
                return this.westWall;
            case EAST:
                return this.eastWall;
            default:
                return false;
        }

    }

}
