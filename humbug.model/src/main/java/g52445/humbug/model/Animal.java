package g52445.humbug.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Class Animal is the parent of all the animals
 *
 * @author solimanazoz
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),
    @Type(value = Butterfly.class)})
public abstract class Animal {

    /**
     * The attributes
     */
    private Position positionOnBoard;
    private boolean onStar;

    /**
     * simple constrctor
     *
     * @param positionOnBoard
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * Simple constructor for reading Jackson files
     */
    public Animal() {

    }

    /**
     * Simple getter of positionOnBoard
     *
     * @return
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Simple getter for the attribue onStar
     *
     * @return
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * setter of positionOnBoard
     *
     * @param positionOnBoard
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * setter of onStar
     *
     * @param onStar
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Method with out body
     *
     * @param board the board where the animals stands
     * @param direction the direction of where the animals will move
     * @param animalsmany kind of animals
     * @return
     */
    public abstract Position move(Board board, Direction direction, Animal... animals);

    /**
     * Movement of all crawling animals, some of them crawl one squar and nother two squar , while the spider kept crawl antil the end of board or stop by one obstacle
     *
     * @param board The board of game
     * @param dir the direction
     * @param animals all kinds of animals
     * @param nbMoves nombers of movement for one certain animal
     * @return the position of animal
     */
    protected Position moveOneCrawling(int nbMoves, Board board, Direction dir, Animal... animals) {
        Position posAnimal = animalsCrawling(nbMoves, board, dir, animals);
        if (posAnimal == null) {
            setPositionOnBoard(null);
            return null;
        } else if (board.getSquareType(posAnimal).equals(SquareType.STAR)) {
            setOnStar(true);
            board.setSquareType(posAnimal, SquareType.GRASS);
        }
        return posAnimal;
    }

    /**
     * Movement of all jumping animals , it jumps one step and stop
     *
     * @param board the board game
     * @param dir the direction
     * @param animals all kinds of animals
     * @return the poistion of tha animal, null of it steps out the board
     */
    protected Position moveOneJumping(Board board, Direction dir, Animal... animals) {
        Position posAnimals = placeFree(board, getPositionOnBoard(), dir, animals);
        if (posAnimals != null) {
            if (board.getSquareType(posAnimals) == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(posAnimals, SquareType.GRASS);
            }
            setPositionOnBoard(posAnimals);
            return getPositionOnBoard();
        } else {
            setPositionOnBoard(null);
            return getPositionOnBoard();
        }
    }

    /**
     * Movement of all flying animals, some of them fly two small square(like Bumbelbee) and some fly three (like Butterfly)
     *
     * @param board the board of the game
     * @param dir the direction
     * @param animals all kinds of animlas
     * @param nbMoves nombers of movement for one certain animal
     * @return the poistion of tha animal, null of it steps out the board
     */
    protected Position moveOneFlying(int nbMoves, Board board, Direction dir, Animal... animals) {
        if (nbMoves == 2) {
            setPositionOnBoard(placeFree(board, getPositionOnBoard().next(dir), dir, animals));
        } else if (nbMoves == 3) {
            setPositionOnBoard(placeFree(board, getPositionOnBoard().next(dir).next(dir), dir, animals));
        }
        if (getPositionOnBoard() != null) {
            if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
            }
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard();
        } else {
            setPositionOnBoard(null);
            return getPositionOnBoard();
        }
    }

    /**
     * Looking for free place , no animals step on it
     *
     * @param board The board of the game
     * @param dir the direction
     * @param animals all kind of animals
     * @param pos the position to start looking for
     * @return the position of small square, or null in case of end board
     */
    protected Position placeFree(Board board, Position pos, Direction dir, Animal... animals) {
        Position posAnimls = pos;
        boolean free = true;
        while (free) {
            if (!isFree(posAnimls.next(dir), animals)) {
                free = true;
                posAnimls = posAnimls.next(dir);
            } else {
                free = false;
                if (!board.isInside(posAnimls.next(dir))) {
                    posAnimls = null;
                } else {
                    posAnimls = posAnimls.next(dir);
                }
            }
        }
        return posAnimls;
    }

    /**
     * Verify if there is an animal on certain position
     *
     * @param pos the position for testing if it is available (free), no animal stand on it
     * @param animals the animal
     * @return give true if no animal and false otherwise.
     */
    protected boolean isFree(Position pos, Animal... animals) {
        boolean free = true;
        int i = 0;
        while (i < animals.length && free) {
            free = !(animals[i].getPositionOnBoard().equals(pos) && !animals[i].onStar);

            i++;
        }
        return free;
    }

    /**
     * Describe how the crawling animals moves ,Some moves one square ,other moves two or even more
     *
     * @param nbMovesCrwaling nombers of movement for one certain animal
     * @param board the board of the game
     * @param direction the direction
     * @param animals all kinds of animals
     * @return the position after the animals moves, null otherwise
     */
    protected Position animalsCrawling(int nbMovesCrwaling, Board board, Direction direction, Animal... animals) {
        int nbMoves = 0;
        while (board.isInside(getPositionOnBoard().next(direction))) {
            nbMoves++;
            if (board.getSquare(getPositionOnBoard()).hasWall(direction)
                    || board.getSquare(getPositionOnBoard().next(direction)).hasWall(direction.opposite())
                    || !isFree(getPositionOnBoard().next(direction), animals)) {
                setPositionOnBoard(getPositionOnBoard());
                return getPositionOnBoard();
            }
            setPositionOnBoard(getPositionOnBoard().next(direction));
            if (nbMoves == nbMovesCrwaling) {
                return getPositionOnBoard();
            }
            if (nbMoves == nbMovesCrwaling) {
                return getPositionOnBoard();
            }
        }
        if (board.getSquare(getPositionOnBoard()).hasWall(direction)) {
            return getPositionOnBoard();
        } else {
            return null;
        }
    }
}
/**
 *
 *
 */
