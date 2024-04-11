package g52445.atl.project2048.model;

//import g52445.atl.project2048.util.Observable;
import g52445.atl.project2048.util.Observer;

/**
 * Represent the facade of model.
 *
 * @author soliman
 */
public interface FacadeModel {

    void getInitialBoard();

    Board getBoard();

    void move(Direction dir);

    boolean isOver();

    void endGame();
    
    int getScore();

    void addNumber();

    public int getBest();

    public void reset();

    public void registerObserver(Observer obs);

    public void notifyObservers(Object arg);

    public void notifyObservers();

    public void removeObserver(Observer obs);

}
