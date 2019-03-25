package org.raowei.test.pattern.observer;

import java.util.Observable;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:58
 *
 * @author admin
 */
public class Subject extends Observable{
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (this.state != state) {
            this.setChanged();
            this.notifyObservers();
        }
        this.state = state;

    }
}
