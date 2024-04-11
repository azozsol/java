package g52445.atl.asciipaint.model;

/**
 * Represent the coloredShape in asciipaint.
 *
 * @author solimanazoz
 */
public abstract class ColoredShape implements Shape {

    /**
     * The attribute color of the shape.
     */
    private char color;

    /**
     * The constructor of the classe ColoredShape
     *
     * @param color The color by char
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * The getter of the attribute color.
     *
     * @return the color by char.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * The setter of the attribute color
     *
     * @param color the new color
     */
    public void setColor(char color) {
        this.color = color;
    }

}
