package g52445.humbug.model;

/**
 * the board of game is about an array of 2D , contain three type square (GRASS, STAR, NULL)
 *
 * @author solimanazoz
 */
public class Board {

    private Square[][] squares;

    /**
     * Constructor of board
     *
     * @param squares
     */
    public Board(Square[][] squares) {
        this.squares = squares;

    }

    /**
     * Simple constructor for reading Jackson's files
     */
    public Board() {
    }

    /**
     * Simple getter for reading Jackson's files.
     *
     * @return
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Given one square from the board
     *
     * @param pos poistion in the board
     * @return square of type Square
     */
    public Square getSquare(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("The poisiotn is outside: -----> " + pos);
        } else {
            return squares[pos.getRow()][pos.getColumn()];
        }
    }

    /**
     * Initialise the first level of game with 3 Row and 3 column
     *
     * @return the board
     */
    public static Board getInitialBoard() {
        Square[][] sq = {
            {new Square(SquareType.GRASS), new Square(SquareType.GRASS), null},
            {null, new Square(SquareType.GRASS), new Square(SquareType.GRASS)},
            {null, null, new Square(SquareType.STAR)}};
        Board bo = new Board(sq);

        return bo;
    }

    /**
     * It is important to know if the position is inside the board or not ,
     *
     * @param pos position
     * @return true if the position is inside the board (GRASS or STAR) , false otherwise ( NULL)
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("the position unvalid ----> " + pos);
        }
        if (pos.getRow() >= 0 && pos.getRow() < squares.length && pos.getColumn() >= 0 && pos.getColumn() < squares[0].length) {
            if (squares[pos.getRow()][pos.getColumn()] != null) {
                return true;
            }

        }
        return false;
    }

    /**
     * Give us the contain of square
     *
     * @param pos the position
     * @return the type of square (GRASS, STAR )
     */
    public SquareType getSquareType(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("the position is outside the board -----> " + pos);
        }
        return squares[pos.getRow()][pos.getColumn()].getType();
    }

    /**
     * Simple setter
     *
     * @param pos position in the board
     * @param type square type(GRASS, STAR)
     * @return square
     */
    public SquareType setSquareType(Position pos, SquareType type) {
        squares[pos.getRow()][pos.getColumn()].setType(type);
        return squares[pos.getRow()][pos.getColumn()].getType();
    }

    /**
     *
     * @return the nubmer of Row
     */
    public int getNbRow() {
        return squares.length;
    }

    /**
     *
     * @return the number of column
     */
    public int getNbColumn() {
        return squares[0].length;

    }

}
