package g52445.atl.asciipaint.model;

/**
 * Represent the Square
 *
 * @author solimanazoz
 */
public class Square extends Rectangle {

    /**
     * The constructor of the square
     *
     * @param upperLeft the upper left point of the square
     * @param side the side of the square
     * @param color the color of the square
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

}
