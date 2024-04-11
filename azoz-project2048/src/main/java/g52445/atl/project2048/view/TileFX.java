package g52445.atl.project2048.view;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Class for shapping the tile
 * @author soliman
 */
public class TileFX {

    /**
     * Attributs the class.
     */
    private TileColor tileColor;
    private final Text value;
    private final Rectangle rec;

    /**
     * Constructor, building the tile with rectangle shape and specific color.
     * @param value the value of tile
     * @param tileColor  the color of tile.
     */
    public TileFX(int value, TileColor tileColor) {
      
        this.tileColor = tileColor;
        this.rec = new Rectangle();
        this.value = new Text(value+"");
        StackPane stack = new StackPane();
        ColorPicker colorPicker = new ColorPicker(Color.web(this.tileColor.suitableColor(value).getColor()));
        Color color = colorPicker.getValue();
        this.rec.setX(0);
        this.rec.setY(0);
        this.rec.setWidth(95);
        this.rec.setHeight(95);
        this.rec.setFill(color);
        stack.getChildren().addAll(this.rec, this.value);
    }
    /**
     * getting the the whole tile  
     * @return the tile
     */
    public StackPane getTile() {
        StackPane stack = new StackPane();
        stack.getChildren().addAll(this.rec, this.value);
        return stack;
    }
}
