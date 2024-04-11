package g52445.humbug.model;

/**
 * The interface Model groups 4 methods without body
 *
 * @author solimanazoz
 */
public interface Model {

    Board getBoard();

    Animal[] getAnimals();
    
    int getRemainingMoves();

    void startLevel(int level);

    LevelStatus getLevelStatus();

    void move(Position position, Direction direction);
}
