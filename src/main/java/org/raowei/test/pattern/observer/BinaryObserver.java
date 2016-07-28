package org.raowei.test.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:46
 *
 * @author admin
 */
public class BinaryObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        System.out.println("Binary Observer" + Integer.toBinaryString(subject.getState()));
    }


}
