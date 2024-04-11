package g52445.atl.blackjack.model;

/**
 * Interface model
 *
 * @author solimanazoz
 */
public interface Model {

    Deck getDeck();

    Player getPlayer();

    Player getBank();

    void start();

    LevelStatus getLevelStatus();

}
