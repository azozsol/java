package g52445.atl.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author solimanazoz
 */
public class PointTest {

    public PointTest() {
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMove() {
        Point p = new Point(3, 5);
        p.move(4, 7);
        assertEquals(p, new Point(7, 12));
    }

    @Test
    public void testMoveNegfativ() {
        Point p = new Point(2, 7);
        p.move(-1, 1);
        assertEquals(p, new Point(1,8));
    }
    
    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void testDistanceTo() {
        Point p1 = new Point(-5, 3);
        Point p2 = new Point(8, 1);
        assertEquals(p1.distanceTo(p2), Math.sqrt(173), 0.25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDistanceNull(){
        Point p = new Point(-2,1);
        p.distanceTo(null);
    }

}
