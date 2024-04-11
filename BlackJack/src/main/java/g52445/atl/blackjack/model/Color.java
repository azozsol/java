package g52445.atl.blackjack.model;

/**
 * The class enumeration Color discribe the four differnts types of card
 *
 * @author solimanazoz
 */
public enum Color {
    /**
     * The four essentials attributs
     */
    CLUB("Trèfle"),
    DIAMOND("Carreau"),
    HEART("Coeur"),
    SPADE("Pique");

    private final String colors;

    /**
     * Simple constructor
     *
     * @param colors
     */
    private Color(String colors) {
        this.colors = colors;
    }

    /**
     * Simple getter for the attribut color
     *
     * @return the color of card
     */
    public String getColors() {
        return colors;
    }

    /**
     * Print the color
     *
     * @return the card's type 
     */
    @Override
    public String toString() {
        return this.colors;
    }
}
