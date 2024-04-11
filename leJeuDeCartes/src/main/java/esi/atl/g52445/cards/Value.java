package esi.atl.g52445.cards;

/**
 *
 * @author solimanazoz
 */
public enum Value {
    ACE("As"),
    TWO("Deux"),
    THREE("Trois"),
    FOUR("Quatre"),
    FIVE("Cinq"),
    SIX("Six"),
    SEVEN("Sept"),
    EIGHT("Huit"),
    NINE("Neuf"),
    TEN("Dix"),
    JACK("Valet"),
    QUEEN("Dame"),
    KING("Roi");

    private final String values;

    private Value(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return this.values;
    }
}
