package g52445.humbug.controller;

import g52445.humbug.model.*;
import static g52445.humbug.model.LevelStatus.*;
import g52445.humbug.view.text.*;

/**
 * The controller is responsible for the dynamics of the game and updating the view as the game progresses.
 *
 * @author solimanazoz
 */
public class Controller {

    /**
     * The attributs of the class Controller
     */
    public Model game;
    public InterfaceView view;

    /**
     * Simple constructor of class Controller
     *
     * @param game attribut of type Model
     * @param view attribut o type InerfaceView
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Charge the player and start the game on given level , 
     * the game will restart in case of FAIL . In case of WIN, the game will charge the next level. 
     * During the game, you will ask for the animal's position and the direction for where it will move
     */
    public void startGame() {
        this.view.displayMessage("***** Welcome in game HUMBUG *****");
        int level = this.view.askLevel("Chose the level to play: ");
        this.view.displayMessage("Welcome in level: " + level);
        this.game.startLevel(level);
        View v = new View();
        v.displayRemainingMoves(this.game.getRemainingMoves());
        v.displayBoard(this.game.getBoard(), this.game.getAnimals());
        try {
            while (true) {
                Position pos = this.view.askPosition();
                Direction dir = this.view.askDirection();
                this.game.move(pos, dir);
                if (this.game.getLevelStatus().equals(FAIL)) {
                    this.view.displayMessage("Sorry, but you lost this time: ");
                    this.game.startLevel(level);
                }
                v.displayRemainingMoves(this.game.getRemainingMoves());
                this.view.displayMessage("" + this.game.getLevelStatus());
                this.view.displayBoard(this.game.getBoard(), this.game.getAnimals());
                if (this.game.getLevelStatus().equals(WIN)) {
                    this.view.displayMessage("Congratulation You passed the level: " + level);
                    level++;
                    if (level == 49) {
                        level = 100;
                    }
                    this.view.displayMessage("Welcome in level: " + level);
                    this.game.startLevel(level);
                    v.displayBoard(this.game.getBoard(), this.game.getAnimals());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.view.displayError("Somthing went wrong");
        }
    }
}
