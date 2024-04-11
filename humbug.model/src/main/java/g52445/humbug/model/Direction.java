package g52445.humbug.model;

/**
 * To indicate where the animales goes (North , South, East, West), we use the current position and adding the the right direction
 *
 * @author solimanazoz
 */
public enum Direction {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Constructor of the direction
     *
     * @param deltaRow
     * @param deltaColumn
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Simple getter of deltaRow
     *
     * @return
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * simple gitter for deltaColumn
     *
     * @return
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * The methode return the opposit direction
     *
     * @return direction
     */
    public Direction opposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return null;
        }
    }
}
