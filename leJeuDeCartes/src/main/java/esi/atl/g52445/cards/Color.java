package esi.atl.g52445.cards;

/**
 *
 * @author solimanazoz
 */
public enum Color {
    CLUB("Trèfle"),
    DIAMOND("Carreau"),
    HEART("Coeur"),
    SPADE("Pique");

    private final String colors;

    private Color(String colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return this.colors;
    }
}
