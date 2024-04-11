package g52445.atl.project2048.model;

import g52445.atl.project2048.util.Observable;
import g52445.atl.project2048.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represnt the game.
 *
 * @author soliman
 */
public class Game implements FacadeModel, Observable {

    /**
     * The attributes of the game.
     */
    private Board board;
    private int score;
    private int best = 0;
    private List<Observer> listObserver;

    /**
     * Simple constructor
     */
    public Game() {
        this.board = new Board();
        this.score = 0;
        this.listObserver = new ArrayList<>();
    }

    /**
     * Simple constructor
     *
     * @param board The new board.
     * @throws IllegalArgumentException if there is no board.
     */
    public Game(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Ther is no board for the game.");
        }
        this.board = board;
        this.score = 0;
        this.listObserver = new ArrayList<>();
    }

    /**
     * To initialize the board by adding two random number.
     */
    @Override
    public void getInitialBoard() {
        addNumber();
        addNumber();
    }

    /**
     * Simple getter for board.
     *
     * @return The board.
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Allow us to make a movement with certain direction.
     *
     * @param dir The directio
     */
    @Override
    public void move(Direction dir) {
        if (dir == null) {
            throw new IllegalArgumentException("There is no direction to move at.");
        }
        Position pos = new Position(0, 0);
        this.board = compressWithDir(dir);
        for (int i = 0; i < this.board.getBoardGame().length; i++) {
            pos = initPostion(dir, i);
            while (this.board.isInside(pos.next(dir))) {
                if (isEqual(pos, pos.next(dir))) {
                    this.score += merge(pos, pos.next(dir));
                }
                pos = pos.setPostion(pos.next(dir));
            }
        }
        this.board = compressWithDir(dir);
    }

    /**
     * Allow us to make a shift between two diffrents position ,on of them equals to zero.
     *
     * @param pos The position.
     * @param otherPos The another position.
     * @throws IllegalArgumentException if on of the two postions is null.
     */
    public void shift(Position pos, Position otherPos) {
        if (pos == null || otherPos == null) {
            throw new IllegalArgumentException("One of the two position is null: " + pos + otherPos);
        }
        int value = this.board.getValue(otherPos);
        this.board.setValue(pos, value);
        this.board.setValue(otherPos, 0);
    }

    /**
     * Allow us to merge two identicals value at two diffrents positions and save the sum of them on the otherPostion.
     *
     * @param pos The position.
     * @param otherPos The another position.
     * @return The sum of there values.
     * @throws IllegalArgumentException if on of the two postions is null.
     */
    public int merge(Position pos, Position otherPos) {
        if (pos == null || otherPos == null) {
            throw new IllegalArgumentException("One of the two position is null: " + pos + otherPos);
        }
        int value = this.board.getValue(pos);
        this.board.setValue(otherPos, 2 * value);
        this.board.setValue(pos, 0);
        if (best < this.board.getValue(otherPos)) {
            best = this.board.getValue(otherPos);
        }
        return this.board.getValue(otherPos);
    }

    /**
     * Allow us to check if value at two diffrents position are equals.
     *
     * @param pos The position.
     * @param otherPos The another Position.
     * @return True if they are equals, False otherwise.
     * @throws IllegalArgumentException if on of the two postions is null.
     */
    public boolean isEqual(Position pos, Position otherPos) {
        if (pos == null || otherPos == null) {
            throw new IllegalArgumentException("One of the two position is null: " + pos + otherPos);
        }
        return this.board.getValue(pos) == this.board.getValue(otherPos);
    }

    /**
     * Simple getter of the score.
     *
     * @return the score.
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Checking if the game is over, no free place or posible move.
     *
     * @return True if the game is over, False otherwise.
     */
    @Override
    public boolean isOver() {
        if (this.board.isFull()) {
            return !checkTwoNumEqual() && !checkTwoNumEqualBorder();
        }
        return false;
    }
    @Override
    public void endGame() {
        if (isOver()) {
            notifyObservers("gameOver");
        }
    }

    /**
     * Checking if any two values are equals on the board.
     *
     * @return True if there are two value equals to each other.
     */
    private boolean checkTwoNumEqual() {
        int boardLengthRow = this.board.getNbRow();
        int boardLengthCol = this.board.getNbColumn();
        Position pos, nextPosVer, nextPosHor;
        int i = 0;
        while (i < boardLengthRow - 1) {
            int j = 0;
            while (j < boardLengthCol - 1) {
                pos = new Position(i, j);
                nextPosHor = new Position(i, j + 1);
                nextPosVer = new Position(i + 1, j);
                if (isEqual(pos, nextPosHor) || isEqual(pos, nextPosVer)) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    /**
     * Checking if any two values are on the side of board.
     *
     * @return True if found two values equals to each other.
     */
    private boolean checkTwoNumEqualBorder() {
        int boardLengthCol = this.board.getNbColumn();
        for (int j = 0; j < boardLengthCol - 1; j++) {
            if (isEqual(new Position(3, j), new Position(3, j + 1))
                    || isEqual(new Position(j, 3), new Position(j + 1, 3))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Allow us to add a random value (2 or 4) at random position on the board.
     */
    @Override
    public void addNumber() {
        Random rand = new Random();
        int randomNum = rand.nextInt(this.board.sizeAvailablePlaces());
        int boardRow = this.board.availablePlaces()[randomNum] / 10;
        int boardCol = this.board.availablePlaces()[randomNum] % 10;
        this.board.getBoardGame()[boardRow][boardCol] = rand.nextBoolean() ? 2 : 4;
    }

    /**
     * Allow us to compress the board with certain direction.
     *
     * @param dir The direction
     * @return The new board after the compress
     * @throws IllegalArgumentException if there is no direction
     */
    public Board compressWithDir(Direction dir) {
        if (dir == null) {
            throw new IllegalArgumentException("there is no direction");
        }
        int value;
        Position pos = new Position(0, 0);
        for (int i = 0; i < this.board.getBoardGame().length; i++) {
            int cmp = 1;
            pos = initPostion(dir, i);
            while (this.board.isInside(pos.next(dir)) && cmp <= 3) {
                value = this.board.getValue(pos);
                if (value == 0 && !this.board.isFree(pos.next(dir))) {
                    shift(pos, pos.next(dir));
                }
                pos = pos.setPostion(pos.next(dir));

                if (!this.board.isInside(pos.next(dir))) {
                    cmp++;
                    pos = initPostion(dir, i);
                }
            }
        }
        return this.board;
    }

    /**
     * Allow us to initialize a position by certain direction. It makes the beginning point for compress the board at certain direction.
     *
     * @param dir The direction.
     * @param i An index for the row or column.
     * @return The position.
     */
    private Position initPostion(Direction dir, int i) {
        Position pos = new Position(0, 0);
        switch (dir) {
            case DOWN:
                pos = new Position(3, i);
                break;
            case UP:
                pos = new Position(0, i);
                break;
            case LEFT:
                pos = new Position(i, 0);
                break;
            case RIGHT:
                pos = new Position(3 - i, 3);
                break;
            default:
        }
        return pos;
    }

    @Override
    public int getBest() {
        return best;
    }

    @Override
    public void reset() {
        this.board = new Board();
        addNumber();
        addNumber();
        notifyObservers("recommencer");
    }

    public void initialize() {
        this.score = 0;
        addNumber();
        addNumber();
    }

    @Override
    public void registerObserver(Observer obs) {
        if (!listObserver.contains(obs)) {
            this.listObserver.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        if (listObserver.contains(obs)) {
            this.listObserver.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : this.listObserver) {
            ob.update(this, null);
        }
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer ob : this.listObserver) {
            ob.update(this, arg);
        }
    }

}
