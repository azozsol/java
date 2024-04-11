package g52445.atl.project2048.main;

import g52445.atl.project2048.controller.Controller;
import g52445.atl.project2048.model.Game;
import g52445.atl.project2048.view.View;

/**
 * Represent the main class.
 *
 * @author soliman
 */
public class Main {

    /**
     * At the bigenning there were main methode.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller play = new Controller(new Game(), new View());
        play.startGame();
    }

}
