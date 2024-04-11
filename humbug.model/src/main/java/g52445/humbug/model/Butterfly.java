package g52445.humbug.model;

/**
 * The class Bumbelbee inherit from class Animal
 *
 * @author solimanazoz
 */
public class Butterfly extends Animal {

    /**
     * Simple constructor
     *
     * @param positionOnBoard the positio on the board
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Simple constructor
     */
    public Butterfly() {
    }

    /**
     * The animal butterfly flys three smalls squars and then stop
     *
     * @param board the game board
     * @param direction the direction
     * @param animals all kinds of animals
     * @return the position of butterfly after its movement , in case it steps out the board, its position is null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneFlying(3, board, direction, animals);
    }

}
