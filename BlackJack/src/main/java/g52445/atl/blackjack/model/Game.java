package g52445.atl.blackjack.model;

import java.util.ArrayList;

/**
 * Class Game indicates how to start the game and evaluted if the player win or lose, it implements the interface Model
 *
 * @author solimanazoz
 */
public class Game implements Model {

    /**
     * The attributes of the class
     */
    public Player player;
    public Player bank;
    public Deck deck;
    private LevelStatus levelStatus;

    /**
     * Simple getter of attribue player
     *
     * @return the player
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * Simple getter attribute of bank
     *
     * @return the bank
     */
    @Override
    public Player getBank() {
        return bank;
    }

    /**
     * Simple attribute of deck
     *
     * @return the deck
     */
    @Override
    public Deck getDeck() {
        return deck;
    }

    /**
     * Simple attribute of levelStatus
     *
     * @return levelStatus
     */
    @Override
    public LevelStatus getLevelStatus() {
        return upadateLevelStatus();
    }

    /**
     * Creating the game by puting 52 cards on the deck and giving two cards for player and bank
     *
     * @throws IllegalArgumentException it throws un exception if deck is impty ( no cards )
     */
    @Override
    public void start() {
        this.deck = new Deck();
        this.deck.shuffle();
        this.player = new Player(new ArrayList<>(), "N");
        this.bank = new Player(new ArrayList<>(), "N");

        if (this.deck.isEmpty()) {
            throw new IllegalArgumentException("there is no cards in th deck:" + this.deck.size());
        }
        for (int i = 0; i < 2; i++) {
            this.player.getCards().add(this.deck.hit());
            this.bank.getCards().add(this.deck.hit());
        }

    }

    /**
     * Checking if the game is over by calcute the score of the player and bank
     *
     * @return true if player lost and false otherwise
     */
    private boolean isOver() {
        return (this.player.getScore() > 21 || this.player.getScore() < this.bank.getScore());
    }

    /**
     * The game have three status, updating the status of the game, if the payer wins (WIN) ,if he lost (FAIL), otherwise the game still turning (IN_PROGRESS)
     *
     * @return one from three status (WIN, FAIL, IN_PROGRESS
     */
    private LevelStatus upadateLevelStatus() {
        if (this.player.getAskStand().equals("Y")) {
            if (isOver()) {
                return this.levelStatus.FAIL;
            } else {
                return this.levelStatus.WIN;
            }
        } else if (this.player.getScore() > 21) {
            return this.levelStatus.FAIL;
        } else {
            return this.levelStatus.IN_PROGRESS;
        }

    }

}
