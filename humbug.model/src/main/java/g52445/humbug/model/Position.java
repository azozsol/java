package g52445.humbug.model;

import java.util.Objects;

/**
 * Position of where we stand on the game ,so we need two attributs ,the row the column and those define the position .
 *
 * @author solimanazoz
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor of position
     *
     * @param ligne
     * @param colonne
     */
    public Position(int ligne, int colonne) {
        this.row = ligne;
        this.column = colonne;
    }

    public Position() {

    }

    /**
     * Simple getter of row
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Simplz getter of column
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     * Verify if the row equals to the column
     *
     * @return true if they are equals and false the are not
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
     * the hashcode help us to chack out in case the row and the column are the same,so they have the same hash code
     *
     * @return integer nombre
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.column);
    }

    /**
     * To show the coordinate (Row, Column)
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }

    /**
     * Giving the next poistion according to given direction
     *
     * @param direc the direction
     * @return the new position
     */
    public Position next(Direction direc) {
        return new Position(row + direc.getDeltaRow(), column + direc.getDeltaColumn());

    }

}
