package g52445.atl.blackjack.view;

import g52445.atl.blackjack.model.Card;
import g52445.atl.blackjack.model.Color;
import java.util.List;
import java.util.Scanner;
 import​ java.util.regex.Pattern;

/**
 * The class View indicate how the game will appear with the differents colors, it implements the interface InterfaceView
 *
 * @author solimanazoz
 */
public class View implements InterfaceView {

    /**
     * Simple constructor
     */
    public View() {
    }

    /**
     * To print an error message at the screen.
     *
     * @param message the message of type string
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * *
     * To print the title with color
     *
     * @param message the title
     * @return the title with color
     */
    @Override
    public String displayTitle(String message) {
        TerminalColor colorGreen = TerminalColor.BG_GREEN;
        TerminalColor def = TerminalColor.DEFAULT;
        return colorGreen + message + def;
    }

    /**
     * To ask for card. It show the user a message asking him if he want a card or not, by using one right letter, if the user enter wrong letter , the methode will ask him to enter the right letter again.
     *
     * @param message the message for user
     * @return it return one letter , Y ( yes) or N (no).
     */
    @Override
    public String askCard(String message) {
        Scanner clavier = new Scanner(System.in);
        this.displayMessage(message);
        String letter = clavier.nextLine().toUpperCase();
        String regex = "^[Y,N]{1}$";
        while (true) {
            if (Pattern.matches(regex, letter)) {
                return letter;
            } else {
                this.displayMessage("Please chose a rigth letter.");
                this.displayMessage(message);
                letter = clavier.nextLine().toUpperCase();
            }

        }
    }

    /**
     * to dispaly one specifc message
     *
     * @param message the message
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * To translate the cards types into small color icons
     *
     * @param colors the type of cards( CLUB, HAERT, SPADE, DIAMOND)
     * @return small colored icons
     */
    private String toColor(Color colors) {
        TerminalColor fontRed = TerminalColor.RED;
        TerminalColor def = TerminalColor.DEFAULT;
        switch (colors.getColors()) {
            case "Coeur":
                return fontRed + "♥" + def;
            case "Trèfle":
                return "♣";
            case "Pique":
                return "♠";
            case "Carreau":
                return fontRed + "♦" + def;
        }
        return null;
    }

    /**
     * To display the list card of two diffrents color (RED and BLACK)
     *
     * @param cards the cards of the deck
     * @param begin start indice of the cards list.
     * @throws IllegalArgumentException it throws an error if the list of cards is null
     */
    @Override
    public void displayCard(List<Card> cards, int begin) {
        if (cards == null) {
            throw new IllegalArgumentException("it imposible to show any cards: " + cards);
        }
        String[][] tab = new String[3][3];
        while (begin < cards.size()) {
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (i == 1 && j == 1) {
                        tab[i][j] = cards.get(begin).getValues().getValues() + "   ";
                    } else {
                        tab[i][j] = toColor(cards.get(begin).getColors()) + "   ";
                    }
                    System.out.print(tab[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------");
            begin++;
        }
    }
}
