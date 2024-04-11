package g52445.humbug.model;

import static g52445.humbug.model.SquareType.GRASS;
import static g52445.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class SnailTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move towards wall on North
     */
    @Test
    public void testWallNorth() {
        System.out.println("test move to North");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        board.getSquare(new Position(0, 0)).setNorthWall(true);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move towards wall on South
     */
    @Test
    public void testWallSouth() {
        System.out.println("test move to South");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        board.getSquare(new Position(0, 0)).setSouthWall(true);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move towards wall on West
     */
    @Test
    public void testWallWest() {
        System.out.println("test move to West");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        board.getSquare(new Position(0, 0)).setWestWall(true);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move towards wall on East
     */
    @Test
    public void testWallEast() {
        System.out.println("test move to East");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        board.getSquare(new Position(0, 0)).setEastWall(true);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move ,no wall
     */
    @Test
    public void testNoWall() {
        System.out.println("test move no wall");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1);
        board.getSquare(new Position(0, 0)).setEastWall(false);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move towards square contien wall
     */
    @Test
    public void testWallNextSquare() {
        System.out.println("test move to wall in next square");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        board.getSquare(new Position(0, 1)).setWestWall(true);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_3() {
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        board.getSquare(new Position(0, 0)).setWestWall(false);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

}
