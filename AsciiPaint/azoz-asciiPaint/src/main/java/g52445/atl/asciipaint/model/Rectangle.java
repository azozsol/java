package g52445.atl.asciipaint.model;

import java.util.Objects;

/**
 * Represent the Rectangle.
 *
 * @author solimanazoz
 */
public class Rectangle extends ColoredShape {

    /**
     * The attribute upper left point of the rectangle.
     */
    private Point upperLeft;
    /**
     * The attribute width of the rectangle.
     */
    private final double width;
    /**
     * The attribute height of the rectangle.
     */
    private final double height;

    /**
     * The constructor of the rectangle
     *
     * @param upperLeft The upper left point.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The color of the rectangle.
     * @throws IllegalArgumentException if the upper left point is null.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (upperLeft == null) {
            throw new IllegalArgumentException("The upperLeft is null!");
        }
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    /**
     * It allows to move the rectangle
     *
     * @param dx Represent the x , it will sum with the x of upper left point
     * @param dy Represent the y , it will sum with the y of upper left point
     */
    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    /**
     * It allows to generate the hachCode
     *
     * @return The hachCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.upperLeft);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        return hash;
    }

    /**
     * It allows to check if they are equals
     *
     * @param obj an object
     * @return true if they are equals, false otherwise
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
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (!Objects.equals(this.upperLeft, other.upperLeft)) {
            return false;
        }
        return true;
    }

    /**
     * It allows to check if a point is inside the rectangle or not
     *
     * @param p The point
     * @return True if the point is inside, flase otherwise
     * @throws IllegalArgumentException if the point is null
     */
    @Override
    public boolean isInside(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("The point is null");
        }
        return p.getX() >= this.upperLeft.getX()
                && (p.getX() - (this.upperLeft.getX()) < this.width)
                && (p.getY() >= this.upperLeft.getY())
                && (p.getY() - (this.upperLeft.getY()) < this.height);
    }
}
