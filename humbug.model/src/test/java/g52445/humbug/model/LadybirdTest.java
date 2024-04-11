package g52445.humbug.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static g52445.humbug.model.SquareType.GRASS;
import static g52445.humbug.model.SquareType.STAR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author solimanazoz
 */
public class LadybirdTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove() {
        System.out.println("move and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_endline() {
        System.out.println("move end line and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_tootheranimal() {
        System.out.println("move to other animal");
        animals[1] = new Snail(new Position(0, 2));
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_stop() {
        System.out.println("move and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove__nextOnStar() {
        System.out.println("move, next on star and win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird (new Position(0, 0)),
            new Snail(new Position(0, 2))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 1)) == GRASS);
    }
     @Test
    public void testMove_passOnStar() {
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 2))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 1)) == GRASS);
    }

    /**
     * Test of move towards wall on East
     */
    @Test
    public void testMoveNextWall() {
        System.out.println("Testing to move wall on EAST");
        board.getSquare(new Position(0, 1)).setEastWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
}
