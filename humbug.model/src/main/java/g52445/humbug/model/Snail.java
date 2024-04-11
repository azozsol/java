package g52445.humbug.model;

/**
 * The Snail is one part of many animals and it extends their attuibut
 *
 * @author solimanazoz
 */
public class Snail extends Animal {

    /**
     * Simple constructor of class Snail
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Simpel cosntrcutor for reading Jackson's files.
     */
    public Snail() {
    }

    /**
     * the snail crawl just one step for direction
     *
     * @param board the board is where the Snail stand on and move on it
     * @param direction the direction of where the Snail will move
     * @param animals In this class is Snail
     * @return The position of where the Snail stand on the board
     */
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneCrawling(1, board, direction, animals);
    }
}
