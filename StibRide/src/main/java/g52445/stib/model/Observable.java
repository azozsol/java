package g52445.stib.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import g52445.stib.presenter.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nadou
 */
public class Observable {

    List<Observer> pathObservers = new ArrayList<>();

    /**
     * Allows to register observer to observe the observable.
     *
     * @param observer the given observer.
     */
    public void registerObserver(Observer observer) {
        if (!this.pathObservers.contains(observer)) {
            this.pathObservers.add(observer);
        }
    }

    /**
     * Removes observer from the list of observers.
     *
     * @param observer the given observer.
     */
    public void removeObserver(Observer observer) {
        if (this.pathObservers.contains(observer)) {
            this.pathObservers.remove(observer);
        }
    }

    /**
     * Allows to notify all observers of the new state of observable.
     *
     */
    public void notifyPathObservers() {
        for (Observer obs : this.pathObservers) {
            obs.update();
        }
    }
}

