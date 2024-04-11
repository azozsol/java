package g52445.atl.blackjack.model;

/**
 *
 * @author solimanazoz
 */
public enum Value {
    ACE("1", 11),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("D", 10),
    KING("K", 10);

    private final String values;
    private final int nombers;

    private Value(String values, int nombers) {
        this.values = values;
        this.nombers = nombers;
    }

    public String getValues() {
        return values;
    }

    public int getNombers() {
        return nombers;
    }

    @Override
    public String toString() {
        return this.values;
    }
}
