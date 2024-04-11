package g52445.atl.project2048.view;

/**
 * Enumeration for color the game.
 * @author soliman
 */
public enum TileColor {
    NOCOLOR("#cdc1b4"),
    COLOR2("#eee4da"),
    COLOR4("#ede0c8"),
    COLOR8("#f2b179"),
    COLOR16("#f59563"),
    COLOR32("#f67c5f"),
    COLOR64("#f65e3b"),
    COLOR128("#edcf72"),
    COLOR256("#edcc61"),
    COLOR512("#edc850"),
    COLOR1024("#edc53f"),
    COLOR2048("#edc22e");

    private final String color;

    /**
     * Simple Constructor
     * @param color the color 
     */
    private TileColor(String color) {
        this.color = color;
    }

    /**
     * Simple getter.
     * @return the color. 
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Eevery color in tile has one different color.
     * @param value number from 2, 4, 8..2048;
     * @return the color for tile.
     */
    public TileColor suitableColor(int value) {
        switch (value) {
            case 2:
                return COLOR2;
            case 4:
                return COLOR4;
            case 8:
                return COLOR8;
            case 16:
                return COLOR16;
            case 32:
                return COLOR32;
            case 64:
                return COLOR64;
            case 128:
                return COLOR128;
            case 256:
                return COLOR256;
            case 512:
                return COLOR512;
            case 1024:
                return COLOR1024;
            case 2048:
                return COLOR2048;
            default:
                return NOCOLOR;
        }
    }

    @Override
    public String toString() {
        return "TileColor{" + "color=" + color + '}';
    }
}
