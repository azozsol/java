package g52445.atl.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author solimanazoz
 */
public class RectangleTest {

    public RectangleTest() {
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMove() {
        Rectangle r1 = new Rectangle(new Point(4, 4), 6, 7, 'r');
        r1.move(-1, -1);
        Rectangle r2 = new Rectangle(new Point(3, 3), 6, 7, 'r');
        assertEquals(r1, r2);
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInside() {
        Rectangle r = new Rectangle(new Point(4, 4), 6, 7, 'r');
        Point p = new Point(6, 7);
        assertTrue(r.isInside(p));
    }

    @Test
    public void testIsNotInside() {
        Rectangle r = new Rectangle(new Point(4, 4), 6, 7, 'r');
        Point p = new Point(115, 13);
        assertFalse(r.isInside(p));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsInsideNull() {
        Rectangle r = new Rectangle(new Point(4, 4), 6, 7, 'r');
        r.isInside(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperLeftNull() {
        Rectangle r = new Rectangle(null, 2, 8, 'r');
    }
}
