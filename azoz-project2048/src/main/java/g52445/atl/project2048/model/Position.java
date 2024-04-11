package g52445.atl.project2048.model;

/**
 * Represent the position on the board.
 *
 * @author soliman
 */
public class Position {

    /**
     * The attributes of position.
     */
    private final int row;
    private final int column;

    /**
     * The constructor for a defensive copy.
     *
     * @param pos the position to copy.
     */
    public Position(Position pos) {
        this(pos.row, pos.column);
    }

    /**
     * The constructor of the position.
     *
     * @param row the row of position.
     * @param column the column of this position.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * The getter of the row.
     *
     * @return The row.
     */
    public int getRow() {
        return row;
    }

    /**
     * The getter of the column.
     *
     * @return The column.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Allow to tell us if the objects are equals.
     *
     * @param obj a object.
     * @return equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    /**
     * The getter of the hashCode.
     *
     * @return The hashCode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.row;
        hash = 73 * hash + this.column;
        return hash;
    }

    /**
     * Allow us to print the poistion.
     *
     * @return the position.
     */
    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    /**
     * Allow us to return the next direction by certain direction.
     *
     * @param dir The direction
     * @return The next position on the board.
     */
    public Position next(Direction dir) {
        return new Position(row + dir.getDeltaRow(), column + dir.getDeltaColumn());
    }

    /**
     * Allow us to set a new position on the board.
     *
     * @param pos The position.
     * @return The new position.
     * @throws IllegalArgumentException is there is no position.
     */
    public Position setPostion(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("There is no position to set " + pos);
        }
        return new Position(pos);
    }

}
