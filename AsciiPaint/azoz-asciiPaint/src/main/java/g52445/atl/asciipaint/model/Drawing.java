package g52445.atl.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the drawing.
 *
 * @author solimanazoz
 */
public class Drawing {

    /**
     * The attribute shapes.
     */
    private final List<Shape> shapes;
    /**
     * The attribute height of drawing.
     */
    private final int height;
    /**
     * The attribue width of drawing.
     */
    private final int width;

    /**
     * The constructor of drawing.
     */
    public Drawing() {
        this.shapes = new ArrayList<>();
        this.height = 60;
        this.width = 60;
    }

    /**
     * The constructor for defensive copie.
     *
     * @param drawing The drawing
     * @throws IllegalArgumentException If the drawing is null.
     */
    public Drawing(Drawing drawing) {
        if (drawing == null) {
            throw new IllegalArgumentException("The argument skhldn't be null");
        }
        this.shapes = new ArrayList<>();
        this.height = drawing.height;
        this.width = drawing.width;
    }

    /**
     * The constructor of drawing
     *
     * @param height The height of drawing.
     * @param width The width of drawing.
     */
    public Drawing(int height, int width) {
        this.shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * It allows to adding shapes to drawing.
     *
     * @param shape another shape.
     * @throws IllegalArgumentException if the other shape is null
     */
    public void addShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("The drawing is null !");
        }
        this.shapes.add(shape);
    }

    /**
     * It allows to have the first shape at certain point.
     *
     * @param p the point.
     * @return One shape from the list of shapes.
     * @throws IllegalArgumentException if the point is null.
     */
    public Shape getShapeAt(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("The point is null !");
        }
        int i = 0;
        boolean findShape = false;
        Shape shapeAt = null;
        while (i < this.shapes.size() && !findShape) {
            if (this.shapes.get(i).isInside(p)) {
                shapeAt = this.shapes.get(i);
                findShape = true;
            }
            i++;
        }
        return shapeAt;

    }

    /**
     * The getter of height.
     *
     * @return the height.
     */
    int getHeight() {
        return height;
    }

    /**
     * The getter of width.
     *
     * @return The width.
     */
    int getWidth() {
        return width;
    }

    /**
     * The getter of shapes , I had to use it in test( NOT necessary elsewhere ).
     *
     * @return the shapes.
     */
    public List<Shape> getShapes() {
        return new ArrayList<>(this.shapes);
    }

}
