package g52445.atl.asciipaint.model;

/**
 *
 * @author solimanazoz
 */
public interface Shape {

    boolean isInside(Point p);

    void move(double dx, double dy);

    char getColor();
}
