package esi.atl.g52445.cards;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author solimanazoz
 */
public class Main {

    public static void askCard() {
        int nbCard = askInt("How many card you want? ");
        Card cards;
        Deck d = new Deck();
        d.shuffle();
        for (int i = 0; i < nbCard; i++) {
            cards = d.hit();
            System.out.println(cards.toString());
        }
    }

    public static int askInt(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.print(message);
        while (!clavier.hasNextInt()) {
            clavier.nextLine();
            System.out.println("That was not a number.");
            System.out.println(message);
        }
        return clavier.nextInt();
    }

    public static void main(String[] args) {
//        String regex = "^[0-9]+";
//        String number1 = "12";
//        String number2 = "1";
//        String number3 = "123";
//        String number4 = "12  13";
//        System.out.println("number1"+Pattern.matches(regex, number1));
//        System.out.println("number2"+Pattern.matches(regex, number2));
//        System.out.println("number3"+Pattern.matches(regex, number3));
//        System.out.println("number4"+Pattern.matches(regex, number4));
        if (args.length < 1) {
            throw new IllegalArgumentException("Must containe a valeurs ");
        }

        for (int i = 0; i < args.length; i++) {
            int nb = Integer.parseInt(args[i]);
            System.out.println(nb);

        }
    }

}
