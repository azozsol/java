package g52445.atl.asciipaint.model;

/**
 * Represent the asciipaint of the application.
 *
 * @author solimanazoz
 */
public class AsciiPaint {

    /**
     * The attribute drawing of asciipaint
     */
    private Drawing drawing;

    /**
     * The constructor of asciipaint.
     * @param width the width. 
     * @param height the height.
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }

    /**
     * It allows to create a new circle at certain point in drawing
     *
     * @param x The abscissa of the center of circle.
     * @param y The ordinate of the center of circle.
     * @param radius The radius of the circle.
     * @param color The color of the circle
     */
    public void newCircle(int x, int y, double radius, char color) {
        Circle circle = new Circle(new Point(x, y), radius, color);
        this.drawing.addShape(circle);

    }

    /**
     * It allows to create a new rectangle at certain point in drawing.
     *
     * @param x The abscissa of the upper left point of rectangle
     * @param y The ordinate of the upper left point of rectangle
     * @param width The width of rectangle.
     * @param height The height of rectangle.
     * @param color The color of rectangle.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        Rectangle rectangle = new Rectangle(new Point(x, y), width, height, color);
        this.drawing.addShape(rectangle);
    }

    /**
     * It allows to create a new square at certain point in drawing.
     *
     * @param x The abscissa of the upper left point of square
     * @param y The ordinate of the upper left point of square
     * @param side The side of square
     * @param color The color of square
     */
    public void newSquare(int x, int y, double side, char color) {
        Square square = new Square(new Point(x, y), side, color);
        this.drawing.addShape(square);
    }

    /**
     * It allows to form the drawing and putting the differents shapes , it represente the colors of the shapes
     *
     * @return The color of every shape if found one, white space otherwise.
     */
    public String asAscii() {
        String sColor = "";
        Point p;
        for (int i = this.drawing.getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < this.drawing.getWidth(); j++) {
                p = new Point(i, j);
                Shape oneShape = this.drawing.getShapeAt(p);
                if (oneShape == null) {
                    sColor = sColor + " ";
                } else {
                    sColor = sColor + oneShape.getColor();
                }
            }
            sColor = sColor + "\n";
        }

        return sColor;
    }

    /**
     * The getter of drawing , I had to use it in test( NOT necessary elsewhere ).
     *
     * @return the drawing
     */
    public Drawing getDrawing() {
        return drawing;
    }

}
