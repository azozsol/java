package g52445.humbug.model;

/**
 * The class Bumbelbee inherit from class Animal
 *
 * @author solimanazoz
 */
public class Bumbelbee extends Animal {

    /**
     * Simple constructor
     *
     * @param positionOnBoard the positio on the board
     */
    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Simple constructor
     */
    public Bumbelbee() {
    }

    /**
     * The animal bumbelbee fly two smalls squars and then stop
     *
     * @param board the game board
     * @param direction the direction
     * @param animals All kinds of animals in the game
     * @return the position of bumbelbee after its movement , in case it steps out the board, its position is null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneFlying(2, board, direction, animals);
    }

}
