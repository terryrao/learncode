package org.raowei.test.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:55
 *
 * @author admin
 */
public class HexaObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        System.out.println( "Hex String: " + Integer.toHexString(subject.getState()));
    }
}
