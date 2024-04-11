package g52445.atl.asciipaint.view;

import java.util.Scanner;

/**
 * Represent the view in asciipaint.
 *
 * @author solimanazoz
 */
public class View {

    /**
     * The attribute of class view
     */
    private final Scanner in;

    /**
     * Simple constructor
     */
    public View() {
        this.in = new Scanner(System.in);
    }

    /**
     * To introduce the game.
     */
    public void welcome() {
        System.out.println("Welcome in AsciiPaint\n");
    }

    /**
     * To dispalay the instruction at the console.
     */
    public void displayInstructions() {
        System.out.println("Type 'exit' to stop");
        System.out.println("Type 'add' for adding the shape:");
        System.out.println("   - add Circle  'x'  'y'  'radius'  'color'");
        System.out.println("   - add Rectangle  'x'  'y'  'width'  'height'  'color'");
        System.out.println("   - add Square  'x'  'y'  'side'  'color'");
        System.out.println("Type 'show' for drawing the shape!");
        System.out.println("Type 'help' for showing the instructions");
    }

    /**
     * To display an error message.
     *
     * @param message the message.
     */
    public void dispalayError(String message) {
        System.out.println(message);
    }

    /**
     * To asking the command.
     *
     * @return one line of command.
     */
    public String askCommande() {
        System.out.println("Write your command");
        return in.nextLine();
    }

    /**
     * to display the shapes.
     *
     * @param shapes the shapes.
     */
    public void displayShape(String shapes) {
        System.out.println(shapes);
    }

    /**
     * to say goodbay.
     */
    public void exitGame() {
        System.out.println("Bye !");
    }
}
