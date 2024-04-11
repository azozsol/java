package g52445.atl.asciipaint.main;

import g52445.atl.asciipaint.controller.Controller;
import g52445.atl.asciipaint.model.AsciiPaint;
import g52445.atl.asciipaint.view.View;

/**
 *Respresent the main of asciipaint.
 * @author solimanazoz
 */
public class Application {


    public static void main(String[] args) {
        AsciiPaint paint = new AsciiPaint(40,40);
        View view = new View();
        Controller controller = new Controller(paint, view);
        controller.start();

    }
}
