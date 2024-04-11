package g52445.humbug.model;

/**
 * The class Grasshopper inherit from class Animal
 *
 * @author solimanazoz
 */
public class Grasshopper extends Animal {

    /**
     * Simple constructor of class Grasshopper
     *
     * @param positionOnBoard
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }
/**
 * Simple constructor for reading Jackson's files 
 */
    public Grasshopper() {
    }

    /**
     * The animal grasshopper jumps one small squar and then stop
     *
     * @param board the game board
     * @param direction the direction
     * @param animals all kind of animal
     * @return the position of grasshopper after its movement , in case it steps out the board, its position is null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return super.moveOneJumping(board, direction, animals);
    }

}
