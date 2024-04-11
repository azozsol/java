package g52445.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author solimanazoz
 */
public class Level {

    /**
     * The attributs of class Level
     */
    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     * Simple constructor
     *
     * @param board the board
     * @param animals the animals
     * @param nMoves the numbers movements
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Simple constructor for reading Jackson's files
     */
    public Level() {
    }

    /**
     * Simple getter of attribut board
     *
     * @return
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Simple getter of attribut animals
     *
     * @return
     */
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * Simple getter of attribut nMoves
     *
     * @return
     */
    public int getnMoves() {
        return this.nMoves;
    }

    /**
     * Create an level .In every level, there is certain numbers and kinds of aniamls, diffrents shape of board , and numbers of movements
     *
     * @param level the level of game
     * @return instance of game contain board, animals and movments
     */
    public static Level getLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("The level should positive ----> " + level);
        }
        return readLevel(level);
    }

    /**
     *Importing Jackson's files and transfer into java classes
     * @param nLevel one specific level
     * @return The level
     */
    private static Level readLevel(int nLevel) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + nLevel + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
