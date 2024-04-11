package g52445.atl.project2048.model;

import java.util.Objects;

/**
 * Represent the board for the game.
 *
 * @author soliman
 */
public class Board {

    /**
     * The attributes of board.
     */
    private final static int nbRow = 4;
    private final static int nbColumn = 4;
    private int[][] boardGame;

    /**
     * Simple constructor.
     *
     * @param newBoardGame The array of game.
     * @throws IllegalArgumentException if there is no arrray.
     */
    public Board(int[][] newBoardGame) {
        Objects.requireNonNull("There is no array " + newBoardGame);
        this.boardGame = newBoardGame;
    }

    /**
     * Simple constructor.
     */
    public Board() {
        this.boardGame = new int[nbRow][nbColumn];
    }

    /**
     * Sipmle getter for the numbers of row.
     *
     * @return The numbers of row.
     */
    public int getNbRow() {
        return nbRow;
    }

    /**
     * Simple getter for the numbers of column.
     *
     * @return The numbers of column.
     */
    public int getNbColumn() {
        return nbColumn;
    }

    /**
     * Checking if there is a number not equal to zero at certain position.
     *
     * @param pos The position.
     * @return True if ther is no nubmer, False otherwise.
     * @throws IllegalArgumentException if there is no positin to check in.
     */
    public boolean isFree(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Thers is not position to check if equal to zero. " + pos);
        }
        return boardGame[pos.getRow()][pos.getColumn()] == 0;
    }

    /**
     * Checking if the position is inside the board or not.
     *
     * @param pos The position
     * @return True if the position is inside the board, False otherwise.
     * @throws IllegalArgumentException if there is no positin to check in.
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Thers is not position to check if is inside. " + pos);
        }
        return pos.getRow() < nbRow
                && pos.getRow() >= 0
                && pos.getColumn() < nbColumn
                && pos.getColumn() >= 0;
    }

    /**
     * Allow us to get an value at certain position.
     *
     * @param pos The position.
     * @return The value from the board.
     */
    public int getValue(Position pos) {
        return boardGame[pos.getRow()][pos.getColumn()];
    }

    /**
     * Simple getter for the boardGame.
     *
     * @return The boardGame.
     */
    public int[][] getBoardGame() {
        return boardGame;
    }

    /**
     * verify if the board is full of number not equals to zero.
     *
     * @return True if the board if full, False otherwise.
     */
    public boolean isFull() {
        boolean full = true;
        int i = 0;
        while (i < nbRow && full) {
            int j = 0;
            while (j < nbColumn && full) {
                full = !isFree(new Position(i, j));
                j++;
            }
            i++;
        }
        return full;
    }

    /**
     * Allow us to save the availale places at certain positon.
     *
     * @return The array of available places position.
     */
    public int[] availablePlaces() {
        String[] tabStr = new String[16];
        int[] tabInt = new int[16];
        int cpt = 0;
        for (int i = 0; i < nbRow; i++) {
            for (int j = 0; j < nbColumn; j++) {
                if (isFree(new Position(i, j))) {
                    tabStr[cpt++] = i + "" + j;
                }
            }
        }
        for (int l = 0; l < tabStr.length; l++) {
            if (tabStr[l] == null) {
                tabStr[l] = "0";
            }
            tabInt[l] = Integer.parseInt(tabStr[l]);
        }
        return tabInt;
    }

    /**
     * Calculate the numbers of of available places.
     *
     * @return The logic size.
     */
    public int sizeAvailablePlaces() {
        int index = 0;
        int size = 0;
        while (index < availablePlaces().length) {
            if (availablePlaces()[index] != 0) {
                size++;
            }
            index++;
        }
        if (isFree(new Position(0, 0))) {
            size = size + 1;
        }
        return size;
    }

    /**
     * Allow us to put a value at certain position.
     *
     * @param pos The position.
     * @param value The value.
     */
    public void setValue(Position pos, int value) {
        this.boardGame[pos.getRow()][pos.getColumn()] = value;
    }
}
