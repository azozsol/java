package g52445.atl.asciipaint.model;

import java.util.Objects;

/**
 *
 * @author solimanazoz
 */
public class Circle extends ColoredShape {

    private Point center;
    private final double radius;

    public Circle(Point center, double radius, char color) {
        super(color);
        if (center == null || radius <= 0) {
            throw new IllegalArgumentException("There is no circle , maybe the center is null or the radius is zero or less.");
        }
        this.center = new Point(center);
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point p) {
        return this.center.distanceTo(p) <= this.radius;
    }

    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.center);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        return hash;
    }

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
