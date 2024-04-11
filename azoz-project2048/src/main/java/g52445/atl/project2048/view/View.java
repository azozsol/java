package g52445.atl.project2048.view;

import g52445.atl.project2048.model.Board;
import java.util.Scanner;

/**
 * Represnt The view of the game.
 *
 * @author soliman
 */
public class View {

    private final Scanner in;

    /**
     * Simple constructor.
     */
    public View() {
        this.in = new Scanner(System.in);
    }

    /**
     * Represent welcome for the game.
     */
    public void welcome() {
        System.out.println("Welcome in game 2048.");
    }

    /**
     * To exit the game.
     */
    public void exitGame() {
        System.out.println("Bye !");
    }

    /**
     * To show the score.
     *
     * @param score the player score.
     */
    public void showScore(int score) {
        System.out.println("Your score is : " + score);
    }

    /**
     * To display an error.
     */
    public void displayError() {
        System.out.println("Error in command. The letter is not from the list, please try again: ");
    }

    /**
     * To display the instruction.
     */
    public void displayInstruction() {
        System.out.println("To move the numbers, type the following: ");
        System.out.println("   U ---> for moving UP.");
        System.out.println("   D ---> for moving DOWN.");
        System.out.println("   L ---> for moving LEFT.");
        System.out.println("   R ---> for moving RIGHT.");
        System.out.println("   E ---> for EXIT.");
    }

    /**
     * Allow us to ask for command.
     *
     * @param message the message.
     * @return One letter on upper case.
     */
    public String askCommand(String message) {
        String cmd = "";
        System.out.println(message);
        cmd = in.nextLine();
        cmd = cmd.toUpperCase();
        return cmd;
    }

    /**
     * To show the board.
     *
     * @param board The board.
     * @throws IllegalArgumentException if the board is null.
     */
    public void showBoard(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("The board can't be null");
        }
        TerminalColor foR = TerminalColor.RED;
        TerminalColor def = TerminalColor.DEFAULT;
        TerminalColor clG = TerminalColor.BG_GREEN_FG_WHITE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String nb = clG + "" + board.getBoardGame()[i][j] + def;
                if (j == 3) {
                    System.out.print(nb);
                } else {
                    System.out.print(nb + "    ");
                }
            }
            System.out.println();
        }
    }

}
