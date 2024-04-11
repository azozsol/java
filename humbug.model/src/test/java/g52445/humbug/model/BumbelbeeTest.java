package g52445.humbug.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static g52445.humbug.model.SquareType.GRASS;
import static g52445.humbug.model.SquareType.STAR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author solimanazoz
 */
public class BumbelbeeTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove_fall() {
        System.out.println("move and fall");
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove() {
        System.out.println("move and stop");
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     *
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void test_move_step_over_animal() {
        System.out.println("move and step next");
        Bumbelbee instance = (Bumbelbee) animals[0];
        Snail instance1 = (Snail) animals[1];
        instance1.setPositionOnBoard(new Position(0, 2));
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     *
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void test_move_step_over_two_animal() {
        System.out.println("move and step over next two");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 2)),
            new Snail(new Position(0, 3))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove__nextOnStar() {
        System.out.println("move, next on star and win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(STAR)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 2)),
            new Snail(new Position(0, 3))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 4)) == GRASS);
    }
}
