package g52445.atl.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author solimanazoz
 */
public class DrawingTest {

    /**
     * Test of addShape method, of class Drawing.
     */
    @Test
    public void testAddShape() {
        Drawing d = new Drawing();
        d.addShape(new Circle(new Point(1, 2), 4, 'c'));
        assertEquals(d.getShapes().get(0), new Circle(new Point(1, 2), 4, 'c'));
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAt() {
        Drawing d = new Drawing();
        d.addShape(new Circle(new Point(7, 8), 5, 'c'));
        assertEquals(d.getShapeAt(new Point(8, 6)), new Circle(new Point(7, 8), 5, 'r'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructionNull() {
        Drawing d1 = null;
        Drawing d2 = new Drawing(d1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShapeNull() {
        Drawing d = new Drawing();
        d.addShape(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShapeAtnull() {
        Drawing d = new Drawing();
        d.getShapeAt(null);
    }

}
