package g52445.atl.asciipaint.model;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author solimanazoz
 */
public class CircleTest {

    public CircleTest() {
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInside() {
        Circle c = new Circle(new Point(2, 6), 4, 'c');
        Point p = new Point(2, 5);
        assertTrue(c.isInside(p));
    }

    @Test
    public void testIsNotInside() {
        Circle c = new Circle(new Point(2, 6), 4, 'c');
        Point p = new Point(12, 5);
        assertFalse(c.isInside(p));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMove() {
        Circle c1 = new Circle(new Point(2, 2), 2, 'c');
        c1.move(6, 2);
        Point p = new Point(8, 4);
        Circle c2 = new Circle(p, 2, 'c');
        assertEquals(c1, c2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCenterIsNull() {
        Point p = null;
        Circle c = new Circle(p, 4, 'c');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsInsideNull() {
        Circle c = new Circle(new Point(3, 3), 2, 'c');
        Point p = null;
        c.isInside(p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRadiusIsnegatif() {
        Circle c = new Circle(new Point(2, 5), -4, 'c');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRadiusIsZero(){
        Circle c = new Circle(new Point(2, 5), 0, 'c');
    }
}