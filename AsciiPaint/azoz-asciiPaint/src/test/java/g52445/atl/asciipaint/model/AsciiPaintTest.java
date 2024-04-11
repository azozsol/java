package g52445.atl.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author solimanazoz
 */
public class AsciiPaintTest {

    /**
     * Test of newCircle method, of class AsciiPaint.
     */
    @Test
    public void testNewCircle() {
        AsciiPaint asPaint = new AsciiPaint(40,40);
        asPaint.newCircle(5, 6, 4, 'c');
        assertEquals(asPaint.getDrawing().getShapeAt(new Point(5, 6)),
                new Circle(new Point(5, 6), 4, 'c'));
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test
    public void testNewRectangle() {
        AsciiPaint asPaint = new AsciiPaint(40,40);
        asPaint.newRectangle(4, 4, 5, 3, 'r');
        assertEquals(asPaint.getDrawing().getShapeAt(new Point(4, 4)),
                new Rectangle(new Point(4, 4), 5, 3, 'r'));
    }

    /**
     * Test of newSquare method, of class AsciiPaint.
     */
    @Test
    public void testNewSquare() {
        AsciiPaint asPaint = new AsciiPaint(40,40);
        asPaint.newSquare(5, 5, 5, 's');
        assertEquals(asPaint.getDrawing().getShapeAt(new Point(6, 6)),
                new Square(new Point(5, 5), 5, 's'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructionNull() {
        Drawing d = null;
        AsciiPaint asPaint = new AsciiPaint(40,40);
    }

}
