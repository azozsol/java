package g52445.atl.project2048.controller;

import g52445.atl.project2048.model.Direction;
import g52445.atl.project2048.view.View;
import g52445.atl.project2048.model.FacadeModel;

/**
 * represnt the heart of game.
 * 
 * @author soliman
 */
public class Controller {

    
    private FacadeModel game;
    private View view;
    private Direction chosenDirection;

    /**
     * Simple constructor.
     * 
     * @param game The game.
     * @param view The veiw.
     */
    public Controller(FacadeModel game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Allow us to play the game 2048.
     * The board appears with 4 rows and 4 columns, two random values (2 or 4) at random postion.
     * The game ask the player for his movement.
     * If the player enter a wrong command , The game will ask him to correct his movement.
     * 
     */
    public void startGame() {
        this.view.welcome();
        this.game.getInitialBoard();
        this.view.showBoard(this.game.getBoard());
        this.view.displayInstruction();

            while (!this.game.isOver()) {
                String command = view.askCommand("Enter command: ");
         
                switch (command) {
                    case "U":
                        chosenDirection = Direction.UP;
                        break;
                    case "D":
                        chosenDirection = Direction.DOWN;
                        break;
                    case "R":
                        chosenDirection = Direction.RIGHT;
                        break;
                    case "L":
                        chosenDirection = Direction.LEFT;
                        break;
                    case "E":
                        view.exitGame();
                        System.exit(0);
                        break;
                    default:
                        view.displayError();
                }

                this.game.move(chosenDirection);
                this.game.addNumber();
                this.view.showBoard(this.game.getBoard());
                this.view.showScore(this.game.getScore());
                this.view.displayInstruction();
            }     
    }
}
