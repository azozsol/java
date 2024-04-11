package g52445.atl.blackjack.controller;

import static g52445.atl.blackjack.model.LevelStatus.*;
import g52445.atl.blackjack.model.Model;
import g52445.atl.blackjack.view.InterfaceView;

/**
 * Class Controller is the brain of the game, only from here will the game start and kept continue until the end.
 *
 * @author solimanazoz
 */
public class Controller {

    /**
     * *
     * Two essentials attributes
     */
    public Model game;
    public InterfaceView view;

    /**
     * Simple constructor
     *
     * @param game the game
     * @param view the appearance
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Here, the player and the bank take them own role. 
     * The player will able if want to end the game bu asking for (STAND) with one letter ( Y for yes , N for no).
     * Both of them (the player and bank will have two only cards from packet).
     * Every time the player dosen't chose to STAND, then he will have one additional card ,Unlike the bank , it kept his cards until the next STAND
     * If the player's score more than 21 , he will lose 
     * After the player asking to STAND, if his score is between 21 and score of the bank, he will wins the game.
     */
    public void startGame() {
        this.view.displayMessage(this.view.displayTitle("************| Welcome in Black Jack |************"));
        this.game.start();
        this.view.displayMessage("Bank cards is:");
        this.view.displayCard(this.game.getBank().getCards(), 1);
        this.view.displayMessage("Your cards is:");
        this.view.displayCard(this.game.getPlayer().getCards(), 0);
        try {
            while (this.game.getLevelStatus().equals(IN_PROGRESS)) {
                this.game.getPlayer().setAskStand(this.view.askCard("Do you want to stand (press (Y) for yes or (N) for no"));
                if (this.game.getPlayer().getAskStand().equals("N")) {
                    this.game.getPlayer().getCards().add(this.game.getDeck().getPacket().get(0));
                    this.view.displayCard(this.game.getPlayer().getCards(), 0);
                    this.view.displayMessage("Your cards is:");
                } else {
                    this.game.getPlayer().setAskStand("Y");
                }
                if (this.game.getLevelStatus().equals(WIN)) {
                    this.view.displayMessage("YOU WIN!!!");
                }
                if (this.game.getLevelStatus().equals(FAIL)) {
                    this.view.displayMessage("Sorry, you lost your money!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.view.displayError("Some thing went wrong, pleas ask the developer");
        }
    }

}
