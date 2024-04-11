package esi.atl.g52445.cards;

/**
 *
 * @author solimanazoz
 */
public class Card {

    private Color colors;
    private Value values;

    public Card(Value values, Color colors) {
        if (colors == null || values == null) {
            throw new IllegalArgumentException("The colors and the values shouldn't  be null" + colors + ", " + values);
        }
        this.values = values;
        this.colors = colors;
    }

    public Color getColors() {
        return colors;
    }

    public Value getValues() {
        return values;
    }

    @Override
    public String toString() {
        return this.values + " de " + this.colors;

    }

}
