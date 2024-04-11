package g52445.atl.blackjack.main;

import g52445.atl.blackjack.controller.Controller;
import g52445.atl.blackjack.model.Game;
import g52445.atl.blackjack.view.View;

/**
 *
 * @author solimanazoz
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }

}
