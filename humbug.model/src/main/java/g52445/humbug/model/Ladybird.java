package g52445.humbug.model;

/**
 * The class Ladybird inherit from class Animal
 *
 * @author solimanazoz
 */
public class Ladybird extends Animal {

    /**
     * Simpl constructor
     *
     * @param positionOnBoard the position on the board
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Simple constructor for reading Jackson's files
     */
    public Ladybird() {
    }

    /**
     * The animal Ladybird crawl two smalls squars and then stop
     *
     * @param board the game board
     * @param direction the direction
     * @param animals all kind of the animals
     * @return the position of ladybird after its movement , in case it steps out the board, its position is null;
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneCrawling(2, board, direction, animals);
    }

}
