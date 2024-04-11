package g52445.atl.asciipaint.model;

import java.util.Objects;

/**
 * Represent the circle
 *
 * @author solimanazoz
 */
public class Circle extends ColoredShape {

    /**
     * The attribut center of the circle
     */
    private Point center;
    /**
     * The attribut radius of the circle
     */
    private final double radius;

    /**
     * The constructor of the circle
     *
     * @param center The center of the circle
     * @param radius The radius of the circle
     * @param color the color of te circle
     * @throws IllegalArgumentException if the center is null
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (center == null || radius <= 0) {
            throw new IllegalArgumentException("There is no circle , maybe the center is null or the radius is zero or less.");
        }
        this.center = new Point(center);
        this.radius = radius;
    }

    /**
     * It lets us know if the point is inside the circle or not
     *
     * @param p the point
     * @return True if the point is inside , false otherwise
     * @throws IllegalArgumentException if the point is null
     */
    @Override
    public boolean isInside(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("The point is null");
        }
        return this.center.distanceTo(p) <= this.radius;
    }

    /**
     * It allows to move the center of th circle
     *
     * @param dx represent the x of the move
     * @param dy represent the x of the move
     */
    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    /**
     * It allows to get the hashCode
     *
     * @return the hachCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.center);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        return hash;
    }

    /**
     * It allows to know if equals or not
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
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(this.center, other.center)) {
            return false;
        }
        return true;
    }

}
