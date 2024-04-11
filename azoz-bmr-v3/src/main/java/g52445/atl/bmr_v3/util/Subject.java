package g52445.atl.bmr_v3.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the Subject class.
 *
 * @author soliman
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * Allow to add an observer.
     *
     * @param obs an observer.
     */
    public void register(Observer obs) {
        observers.add(obs);
    }

    /**
     * Allow to remove an observer.
     *
     * @param obs an observer.
     */
    public void unregister(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Allow to notify those observers to update.
     */
    protected void notifyObserver() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
