package g52445.atl.asciipaint.model;

/**
 * Represent the point.
 *
 * @author solimanazoz
 */
public class Point {

    /**
     * The attribute abscissa in the point.
     */
    private double x;
    /**
     * The attribute ordinate in the point.
     */
    private double y;

    /**
     * The constructor of the point.
     *
     * @param p The point which will be copied
     */
    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * The constructor of the point.
     *
     * @param x represnte the x-axis of the abscissa.
     * @param y represnte the y-axis of the ordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * It allows to move the point.
     *
     * @param dx Represent the x , it will sum with the x of point.
     * @param dy Represent the y , it will sum with the y of point.
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * It allows to generate the hachCode.
     *
     * @return The hachCode.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * It allows to check if they are equals.
     *
     * @param obj an object.
     * @return true if they are equals, false otherwise.
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
        final Point other = (Point) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    /**
     * It allows to calculate the distance between two points.
     *
     * @param other the other point.
     * @return The distance between two points.
     * @throws IllegalArgumentException if the other point is null.
     */
    public double distanceTo(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("The point is null");
        }
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
     * The getter of the attribute x
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * The getter of the attribute y
     *
     * @return the y
     */
    public double getY() {
        return y;
    }

}
