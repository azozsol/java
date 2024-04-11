package g52445.atl.asciipaint.model;

/**
 * The interface shape in asciiPaint.
 *
 * @author solimanazoz
 */
public interface Shape {

    /**
     * It allows to if a point is inside the shape or not.
     *
     * @param p an Point.
     * @return true if the point is inside the shape, false otherwise.
     */
    boolean isInside(Point p);

    /**
     * It allows to move the shape.
     *
     * @param dx Represent the x , it will sum with the x of the shape.
     * @param dy Represent the y , it will sum with the y of the shape.
     */
    void move(double dx, double dy);

    /**
     * It allows to get the color of the shape.
     *
     * @return the color.
     */
    char getColor();
}
