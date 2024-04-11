package g52445.atl.blackjack.model;

/**
 * The class card describe the the color and the value of card
 *
 * @author solimanazoz
 */
public class Card {

    /**
     * The attributs
     */
    private Color colors;
    private Value values;

    /**
     * Simple constructor
     *
     * @param values the card's value(
     * @param colors the card's color, discribe the four diffrents types of cardss
     * @throws IllegalArgumentException if the value or he color are null
     */
    public Card(Value values, Color colors) {
        if (colors == null || values == null) {
            throw new IllegalArgumentException("The colors and the values shouldn't be null" + colors + ", " + values);
        }
        this.values = values;
        this.colors = colors;
    }

    /**
     * Simple getter of color
     *
     * @return the card's color
     */
    public Color getColors() {
        return colors;
    }

    /**
     * Simple getter of value
     *
     * @return the card's value
     */
    public Value getValues() {
        return values;
    }

    /**
     * Print the card
     *
     * @return the card
     */
    @Override
    public String toString() {
        return this.values + " de " + this.colors;

    }

}
