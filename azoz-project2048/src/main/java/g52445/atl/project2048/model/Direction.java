package g52445.atl.project2048.model;

/**
 * Represent the direction of an piece.
 *
 * @author soliman
 */
public enum Direction {
    /**
     * The attribute of direction.
     */
    UP(1, 0),
    DOWN(-1, 0),
    LEFT(0, 1),
    RIGHT(0, -1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * The constructor of the direction.
     *
     * @param deltaRow the row base of the direction.
     * @param deltaColumn the column base of the direction.
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * The getter row of the base direction.
     *
     * @return The row.
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * The getter column of the base direction.
     *
     * @return The column.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

}
