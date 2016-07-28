package org.raowei.test.pattern.observer;

import java.util.Observable;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:56
 *
 * @author admin
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject observable = new Subject();
        observable.addObserver(new HexaObserver());
        observable.addObserver(new BinaryObserver());
        observable.addObserver(new OctalObserver());

        System.out.println("First state change: 15");
        observable.setState(15);
        System.out.println("Second state change: 10");
        observable.setState(10);
    }
}
