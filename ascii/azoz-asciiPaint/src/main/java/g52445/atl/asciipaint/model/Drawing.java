package g52445.atl.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solimanazoz
 */
public class Drawing {

    private final List<Shape> shapes;
    private final int height;
    private final int width;

    public Drawing() {
        this.shapes = new ArrayList<>();
        this.height = 60;
        this.width = 60;
    }

    public Drawing(Drawing drawing) {
        if (drawing == null) {
            throw new IllegalArgumentException("The argument skhldn't be null");
        }
        this.shapes = new ArrayList<>();
        this.height = drawing.height;
        this.width = drawing.width;
    }

    public Drawing(int height, int width) {
        this.shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    public void addShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("The drawing is null !");
        }
        this.shapes.add(shape);
    }

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

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

}
