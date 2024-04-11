package g52445.atl.project2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author soliman
 */
public class BoardTest {

    public Board board;

    public final int[][] tab = {
        {0, 2, 3, 4},
        {1, 2, 3, 4},
        {1, 2, 3, 4},
        {1, 2, 3, 4},};

    @Test
    public void testIsFreeTrue() {
        this.board = new Board(this.tab);
        Position pos = new Position(0, 0);
        boolean result = this.board.isFree(pos);
        boolean expect = true;
        assertEquals(result, expect);
    }

    @Test
    public void testIsFreeFalse() {
        this.board = new Board(this.tab);
        Position pos = new Position(2, 1);
        boolean result = this.board.isFree(pos);
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsInsideTrue() {
        this.board = new Board(this.tab);
        Position pos = new Position(1, 2);
        boolean result = this.board.isInside(pos);
        boolean expect = true;
        assertEquals(result, expect);
    }

    @Test
    public void testIsInsideFalse() {
        this.board = new Board(this.tab);
        Position pos = new Position(4, 2);
        boolean result = this.board.isInside(pos);
        boolean expect = false;
        assertEquals(result, expect);

    }

    @Test
    public void testIsFullTrue() {
        int[][] tab = {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        this.board = new Board(tab);
        boolean result = this.board.isFull();
        boolean expect = true;
        assertEquals(result, expect);
    }

    @Test
    public void testIsFullOnPleaceAvailable() {
        int[][] tab = {
            {1, 2, 3, 4},
            {1, 0, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},};
        this.board = new Board(tab);
        boolean result = this.board.isFull();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsFullFourPleaceAvailable() {
        int[][] tab = {
            {0, 2, 3, 4},
            {1, 0, 3, 4},
            {1, 2, 0, 4},
            {1, 2, 3, 0},};
        this.board = new Board(tab);
        boolean result = this.board.isFull();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testIsFullAllPleaceAvailable() {
        int[][] tab = new int[4][4];
        this.board = new Board(tab);
        boolean result = this.board.isFull();
        boolean expect = false;
        assertEquals(result, expect);
    }

    @Test
    public void testAvailablePlaces() {
        int[][] tab = {
            {0, 2, 3, 0},
            {1, 0, 0, 4},
            {1, 0, 0, 4},
            {0, 2, 3, 0},};
        this.board = new Board(tab);
        int[] result = this.board.availablePlaces();
        int[] expect = {0, 3, 11, 12, 21, 22, 30, 33, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(result, expect);
    }

    @Test
    public void testAvailablePlacesNoFree() {
        int[][] tab = {
            {6, 2, 3, 4},
            {1, 3, 6, 4},
            {1, 7, 9, 4},
            {1, 2, 3, 2},};
        this.board = new Board(tab);
        int[] result = this.board.availablePlaces();
        int[] expect = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(result, expect);
    }

    @Test
    public void testAvailablePlacesAllFree() {
        int[][] tab = new int[4][4];
        this.board = new Board(tab);
        int[] result = this.board.availablePlaces();
        int[] expect = {0, 1, 2, 3, 10, 11, 12, 13, 20, 21, 22, 23, 30, 31, 32, 33};
        assertArrayEquals(result, expect);
    }

    @Test
    public void testSizeAvailablePlacesRow() {
        int[][] tab = {
            {0, 0, 0, 0},
            {1, 3, 6, 4},
            {1, 7, 9, 4},
            {1, 2, 3, 2},};
        this.board = new Board(tab);
        int result = this.board.sizeAvailablePlaces();
        int expect = 4;
        assertEquals(result, expect);
    }

    @Test
    public void testSizeAvailablePlacesColumn() {
        int[][] tab = {
            {2, 4, 0, 3},
            {1, 3, 0, 4},
            {1, 7, 0, 4},
            {1, 2, 0, 6},};
        this.board = new Board(tab);
        int result = this.board.sizeAvailablePlaces();
        int expect = 4;
        assertEquals(result, expect);
    }

    @Test
    public void testSizeAvailablePlacesAll() {
        int[][] tab = new int[4][4];
        this.board = new Board(tab);
        int result = this.board.sizeAvailablePlaces();
        int expect = 16;
        assertEquals(result, expect);
    }

    @Test
    public void testSizeAvailablePlacesOne() {
        int[][] tab = {
            {2, 4, 5, 3},
            {1, 3, 6, 4},
            {1, 7, 9, 4},
            {1, 2, 3, 0},};
        this.board = new Board(tab);
        int result = this.board.sizeAvailablePlaces();
        int expect = 1;
        assertEquals(result, expect);
    }
}
