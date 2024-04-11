package g52445.atl.blackjack.model;

import java.util.List;

/**
 * Class Player indicate for player could behave during the game.
 *
 * @author solimanazoz
 */
public class Player {

    /**
     * The attributes
     */
    private List<Card> cards;
    private int score;
    private String askStand;

    /**
     * Simple constructor ,initialize the player and giving him zero score at the begin.
     *
     * @param cards the cards between the hands of the player
     * @param askStand asking for stand means to end the round, will be by on letter y for yes and N for no.
     */
    public Player(List<Card> cards, String askStand) {
        if (cards == null) {
            throw new IllegalArgumentException("The player dosen't have cards: " + cards);
        }
        this.cards = cards;
        this.score = 0;
        this.askStand = askStand;
    }

    /**
     * Simple getter for the attribute askStand
     *
     * @return letter
     */
    public String getAskStand() {
        return askStand;
    }

    /**
     * Simple getter for the attribute score,
     *
     * @return the score
     */
    public int getScore() {
        return sommeScore();
    }

    /**
     * Calculat the somme of card's score
     *
     * @return the somme
     */
    public int sommeScore() {
        int somme = 0;
        int i = 0;
        while (i < cards.size()) {
            somme += cards.get(i).getValues().getNombers();
            i++;
        }
        return somme;
    }

    /**
     * Simple setter for attribute askStand
     *
     * @param askStand one letter (Y) or (N)
     */
    public void setAskStand(String askStand) {
        this.askStand = askStand;
    }

    /**
     *Simple getter of the attribute cards
     * @return the list of cards
     */
    public List<Card> getCards() {
        return cards;
    }

}
