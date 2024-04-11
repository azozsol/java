package g52445.humbug.main;

import g52445.humbug.controller.Controller;
import g52445.humbug.model.Game;
import g52445.humbug.view.text.View;

/**
 * The main class
 *
 * @author solimanazoz
 */
public class Main {

    /**
     *Only from her ,the game run
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }

}
