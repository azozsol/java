package g52445.atl.asciipaint.controller;

import g52445.atl.asciipaint.model.AsciiPaint;
import g52445.atl.asciipaint.view.View;

/**
 * Represent the controllor in asciipaint
 *
 * @author solimanazoz
 */
public class Controller {

    /**
     * The attribute paint
     */
    private final AsciiPaint paint;
    /**
     * The attribute view.
     */
    private final View view;

    /**
     * The constructor of the class
     *
     * @param paint The paint
     * @param view The view
     */
    public Controller(AsciiPaint paint, View view) {
        this.paint = paint;
        this.view = view;
    }

    /**
     * It allows to start the game by certain instructions, we have to folow it attentively, otherwise there is a message will appear.
     */
    public void start() {
        this.view.welcome();
        this.view.displayInstructions();
        String sCommand = this.view.askCommande();
        while (true) {
            String[] tabCommand = sCommand.toUpperCase().split(" ");
            switch (tabCommand[0]) {
                case "ADD":
                    addShape(tabCommand);
                    break;
                case "SHOW":
                    this.view.displayShape(this.paint.asAscii());
                    break;
                case "HELP":
                    this.view.displayInstructions();
                    break;
                case "EXIT":
                    this.view.exitGame();
                    System.exit(0);
                    break;
                default:
                    this.view.dispalayError("What you type is not understandable. Please try again.");
            }
            sCommand = this.view.askCommande();
        }
    }

    /**
     * It allows to transfer the command of type string into new shapes( Circle, Rectangle and Square)
     *
     * @param tabCommand the array of command
     */
    private void addShape(String[] tabCommand) {
        if (tabCommand[1].matches("CIRCLE") && tabCommand.length == 6) {
            this.paint.newCircle(
                    Integer.parseInt(tabCommand[2]),
                    Integer.parseInt(tabCommand[3]),
                    Integer.parseInt(tabCommand[4]),
                    tabCommand[5].charAt(0));
        } else if (tabCommand[1].matches("RECTANGLE") && tabCommand.length == 7) {
            this.paint.newRectangle(
                    Integer.parseInt(tabCommand[2]),
                    Integer.parseInt(tabCommand[3]),
                    Integer.parseInt(tabCommand[4]),
                    Integer.parseInt(tabCommand[5]),
                    tabCommand[6].charAt(0));
        } else if (tabCommand[1].matches("SQUARE") && tabCommand.length == 6) {
            this.paint.newSquare(
                    Integer.parseInt(tabCommand[2]),
                    Integer.parseInt(tabCommand[3]),
                    Integer.parseInt(tabCommand[4]),
                    tabCommand[5].charAt(0));
        } else {
            this.view.dispalayError("That not shape");
        }
    }
}
