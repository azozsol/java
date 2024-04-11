package g52445.atl.project2048.controller;

import g52445.atl.project2048.model.Direction;
import g52445.atl.project2048.model.FacadeModel;
import g52445.atl.project2048.view.ViewFX;
//import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author soliman
 */
public class ControllerFX {

    private FacadeModel game;
    private ViewFX view;

    /**
     * Constructor of Play
     *
     * @param game represents the model
     */
    public ControllerFX(FacadeModel game, ViewFX view) {
        this.game = game;
        this.view = view;
    }

    public FacadeModel getGame() {
        game.addNumber();
        return game;
    }

    public void addObserver() {
        this.game.registerObserver(this.view);
    }

    public void start(KeyEvent event) {
        move(event);
        this.game.endGame();
        if (!this.game.getBoard().isFull()) {
            this.game.addNumber();
            int[][] board = this.game.getBoard().getBoardGame();
            this.view.showBoard(board);
        }
    }

    public void move(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                this.game.move(Direction.UP);
                break;
            case DOWN:
                this.game.move(Direction.DOWN);
                break;
            case RIGHT:
                this.game.move(Direction.RIGHT);
                break;
            case LEFT:
                this.game.move(Direction.LEFT);
                break;
            case ESCAPE:
                System.exit(0);
            default:
                break;
        }
        event.consume();
    }

    public void ResetButton() {
        this.game.reset();
        int[][] board = this.game.getBoard().getBoardGame();
        this.view.showBoard(board);
    }

    public void initialize() {
        this.game.getInitialBoard();
        int[][] board = this.game.getBoard().getBoardGame();
        this.view.showBoard(board);
    }

}
