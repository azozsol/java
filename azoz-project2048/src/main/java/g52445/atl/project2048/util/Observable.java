package g52445.atl.project2048.util;

/**
 *
 * @author soliman
 */
public interface Observable {

    public void registerObserver(Observer obs);

    public void removeObserver(Observer obs);

    public void notifyObservers();

    public void notifyObservers(Object arg);
}
