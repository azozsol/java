package g52445.atl.asciipaint.view;

import java.util.Scanner;

/**
 *
 * @author solimanazoz
 */
public class View {

    private final Scanner in;

    public View() {
        this.in = new Scanner(System.in);
    }

    public void welcome() {
        System.out.println("Welcome in AsciiPaint\n");
    }

    public void displayInstructions() {
        System.out.println("Type 'exit' to stop");
        System.out.println("Type 'add' for adding the shape:");
        System.out.println("   - add Circle  'x'  'y'  'radius'  'color'");
        System.out.println("   - add Rectangle  'x'  'y'  'width'  'height'  'color'");
        System.out.println("   - add Square  'x'  'y'  'side'  'color'");
        System.out.println("Type 'show' for drawing the shape!");
        System.out.println("Type 'help' for showing the instructions");
    }

    public void dispalayError(String message) {
        System.out.println(message);
    }

    public String askCommande() {
        System.out.println("Write your command");
        return in.nextLine();
    }

    public void displayShape(String ascii) {
        System.out.println(ascii);
    }

}
