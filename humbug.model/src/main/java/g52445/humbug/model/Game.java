package g52445.humbug.model;

import static g52445.humbug.model.LevelStatus.*;

/**
 * The class Game implements the interface Model, it takes two attributs of types (Board , Animal)
 *
 * @author solimanazoz
 */
public class Game implements Model {

    /**
     * The attributs of class Game
     */
    public Board board;
    public Animal[] animals;
    public int remainingMoves;
    public int currentLevel;
    private LevelStatus levelStatus;

    /**
     * Getter of attribut levelStatus
     *
     * @return one of four level status(WIN, FAIL, NOT_STARTED, IN_PROGRESS) ,it depends the game situation
     */
    @Override
    public LevelStatus getLevelStatus() {
        return updateLevelStatus();
    }

    /**
     * Simple getter of attribute remaingMoves
     *
     * @return how remain moves
     */
    @Override
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * Simple getter of attribut currentLevel
     *
     * @return
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * the getter of attribut board
     *
     * @return
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * the getter of attribut animals
     *
     * @return
     */
    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * Simple setter
     *
     * @param levelStatus
     */
    public void setLevelStatus(LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }

    /**
     * Creating the first level of the game
     *
     * @param level level of the game , starting with 1°
     * @exception IllegalArgumentException if the level is under the 1
     */
    @Override
    public void startLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("The game level should start by 1 ---->" + level);
        }
        this.currentLevel = level;
        this.board = Level.getLevel(level).getBoard();
        this.animals = Level.getLevel(level).getAnimals();
        this.remainingMoves = Level.getLevel(level).getnMoves();
    }

    /**
     * The game have four status. Updating the status of game
     *
     * @return one of four status (WIN, FAIL, IN_PROGRESS, NOT_STARTED)
     */
    private LevelStatus updateLevelStatus() {
        if (isOver() && this.remainingMoves == 0) {
            return this.levelStatus.WIN;
        }
        if (!isOver() && this.remainingMoves == 0 || isAnimalOut()) {
            return this.levelStatus.FAIL;
        }
        if (!isOver()) {
            return this.levelStatus.IN_PROGRESS;
        } else {
            return this.levelStatus.NOT_STARTED;
        }

    }

    /**
     * Checking if all nimals on their stars or not
     *
     * @return true if al animals on stars , false otherwise
     */
    private boolean isOver() {
        boolean everyOnStar = true;
        for (Animal animal : this.animals) {
            if (!animal.isOnStar()) {
                everyOnStar = false;
            }

        }
        return everyOnStar;
    }

    /**
     * Checking if thers is animal out the board
     *
     * @return true if animal out, false otherwise
     */
    private boolean isAnimalOut() {
        for (Animal animal : this.animals) {
            if (animal.getPositionOnBoard() == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Making the animal move form their position to another position
     *
     * @param position current poisiotn of animal
     * @param direction the direction to where the animal will move
     */
    @Override
    public void move(Position position, Direction direction) {
        if (position == null || direction == null) {
            throw new IllegalArgumentException("There is null");
        }
        if (getLevelStatus().equals(IN_PROGRESS)) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(position)) {
                    Position posAnimal = animal.getPositionOnBoard();
                    animal.move(this.board, direction, this.animals);
                    setLevelStatus(getLevelStatus());
                    if (!posAnimal.equals(animal.getPositionOnBoard())) {
                        this.remainingMoves--;
                    }
                }
            }
        } else if (getLevelStatus().equals(NOT_STARTED)) {
            throw new IllegalStateException("The Game not in progress");
        }

    }
}
