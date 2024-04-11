package g52445.atl.asciipaint.model;

/**
 *
 * @author solimanazoz
 */
public abstract class ColoredShape implements Shape{
    
    private char color;

    public ColoredShape(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
    
    
}
