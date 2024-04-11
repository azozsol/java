package g52445.atl.project2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author soliman
 */
public class GameTest {

    private Game game;

    public GameTest() {
    }

    @Test
    public void testIsOverFalse1() {
        int[][] tab = {
            {0, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = game.isOver();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsOverFalse2() {
        int[][] tab = {
            {2, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = game.isOver();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsOverFalse3() {
        int[][] tab = {
            {0, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = game.isOver();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsOverFalse4() {
        int[][] tab = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 15},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = game.isOver();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsOverTrue() {
        int[][] tab = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = game.isOver();
        boolean expect = true;
        assertEquals(result, expect);
    }

    @Test
    public void testIsEqualFalse() {
        int[][] tab = {
            {2, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = this.game.isEqual(new Position(3, 3), new Position(1, 1));
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsEqualTrue() {
        int[][] tab = {
            {2, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        boolean result = this.game.isEqual(new Position(3, 3), new Position(2, 3));
        boolean expect = true;
        assertEquals(result, expect);
    }

    @Test
    public void testCompressWithDirUp() {
        int[][] tab = {
            {1, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 3, 0},
            {0, 0, 0, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.compressWithDir(Direction.UP);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {1, 2, 3, 4},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testCompressWithDirDown() {
        int[][] tab = {
            {1, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 3, 0},
            {0, 0, 0, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.compressWithDir(Direction.DOWN);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 2, 3, 4},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testCompressWithDirLeft() {
        int[][] tab = {
            {1, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 3, 0},
            {0, 0, 0, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.compressWithDir(Direction.LEFT);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {1, 0, 0, 0},
            {2, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testCompressWithDirRight() {
        int[][] tab = {
            {1, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 3, 0},
            {0, 0, 0, 4},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.compressWithDir(Direction.RIGHT);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {0, 0, 0, 1},
            {0, 0, 0, 2},
            {0, 0, 0, 3},
            {0, 0, 0, 4},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testCompressWithDirUpFull() {
        int[][] tab = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.compressWithDir(Direction.UP);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testShift() {
        int[][] tab = {
            {1, 0, 0, 0},
            {2, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.shift(new Position(0, 1), new Position(0, 0));
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {0, 1, 0, 0},
            {2, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testMergeAndScore() {
        int[][] tab = {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        Board board = new Board(tab);
        this.game = new Game(board);
        int resultScore = this.game.merge(new Position(1, 0), new Position(0, 0));
        int expectScore = 2;
        int[][] resultBoard = this.game.getBoard().getBoardGame();
        int[][] expectBoard = {
            {2, 0, 0, 0},
            {0, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        assertArrayEquals(expectBoard, resultBoard);
        assertEquals(expectScore, resultScore);
    }

    @Test
    public void testMove() {
        int[][] tab = {
            {1, 0, 0, 0},
            {2, 0, 0, 0},
            {3, 0, 0, 0},
            {4, 0, 0, 0},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.move(Direction.RIGHT);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {0, 0, 0, 1},
            {0, 0, 0, 2},
            {0, 0, 0, 3},
            {0, 0, 0, 4},};
        assertArrayEquals(expect, result);
    }

    @Test
    public void testMoveAndMerge() {
        int[][] tab = {
            {1, 1, 1, 1},
            {2, 2, 0, 0},
            {3, 3, 3, 0},
            {4, 0, 0, 0},};
        Board board = new Board(tab);
        this.game = new Game(board);
        this.game.move(Direction.RIGHT);
        int[][] result = this.game.getBoard().getBoardGame();
        int[][] expect = {
            {0, 0, 2, 2},
            {0, 0, 0, 4},
            {0, 0, 3, 6},
            {0, 0, 0, 4},};
        assertArrayEquals(expect, result);
    }

}
