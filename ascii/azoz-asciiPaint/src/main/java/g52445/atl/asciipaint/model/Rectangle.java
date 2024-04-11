package g52445.atl.asciipaint.model;

import java.util.Objects;

/**
 *
 * @author solimanazoz
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private final double width;
    private final double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (upperLeft == null) {
            throw new IllegalArgumentException("The upperLeft is null!");
        }
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.upperLeft);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
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

    @Override
    public boolean isInside(Point p) {
        return p.getX() >= this.upperLeft.getX()
                && (p.getX() - (this.upperLeft.getX()) < this.width)
                && (p.getY() >= this.upperLeft.getY())
                && (p.getY() - (this.upperLeft.getY()) < this.height);
    }
}
