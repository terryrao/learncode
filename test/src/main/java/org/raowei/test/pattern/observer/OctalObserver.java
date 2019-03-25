package org.raowei.test.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:54
 *
 * @author admin
 */
public class OctalObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }


}
