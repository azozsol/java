package g52445.atl.asciipaint.model;

/**
 *
 * @author solimanazoz
 */
public class AsciiPaint {

    private Drawing drawing;

    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    public AsciiPaint(Drawing drawing) {
        if (drawing == null) {
            throw new IllegalArgumentException("The argumment shoudn't be null");
        }
        this.drawing = new Drawing(drawing);
    }

    public void newCircle(int x, int y, double radius, char color) {
        Circle circle = new Circle(new Point(x, y), radius, color);
        this.drawing.addShape(circle);

    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        Rectangle rectangle = new Rectangle(new Point(x, y), width, height, color);
        this.drawing.addShape(rectangle);
    }

    public void newSquare(int x, int y, double side, char color) {
        Square square = new Square(new Point(x, y), side, color);
        this.drawing.addShape(square);
    }

    public String asAscii() {
        String sColor = "";
        Point p;
        for (int i = this.drawing.getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < this.drawing.getWidth(); j++) {
                p = new Point(i, j);
                Shape s = this.drawing.getShapeAt(p);
                if (s == null) {
                    sColor = sColor + " ";
                } else {
                    sColor = sColor + s.getColor();
                }
            }
            sColor = sColor + "\n";
        }
        
        return sColor;
    }
}
