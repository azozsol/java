package g52445.humbug.model;

/**
 * The class Spider inherit from class Animals
 *
 * @author solimanazoz
 */
public class Spider extends Animal {

    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Simple constructor for reading Jackson's files
     */
    public Spider() {
    }

    /**
     * Moving the spider is diffrient from the snail, it keep moving until falling out or if face of an obstacle like animals or walls.
     *
     * @param board the board
     * @param direction the direction
     * @param animals all kinds of animals
     * @return the poisiotn of where the spider is stand, if stand on sart or on grass or fallout
     */
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneCrawling(-1, board, direction, animals);
    }

}
