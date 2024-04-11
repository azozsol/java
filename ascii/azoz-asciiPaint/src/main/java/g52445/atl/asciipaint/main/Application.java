package g52445.atl.asciipaint.main;

import g52445.atl.asciipaint.controller.Controller;
import g52445.atl.asciipaint.model.AsciiPaint;
import g52445.atl.asciipaint.model.Drawing;
import g52445.atl.asciipaint.view.View;

/**
 *
 * @author solimanazoz
 */
public class Application {


    public static void main(String[] args) {
        Drawing drawing = new Drawing(30, 30);
        AsciiPaint paint = new AsciiPaint(drawing);
        View view = new View();
        Controller controller = new Controller(paint, view);
        controller.start();

    }
}
