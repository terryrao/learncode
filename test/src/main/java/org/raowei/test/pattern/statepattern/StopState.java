package org.raowei.test.pattern.statepattern;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:10
 *
 * @author admin
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "stop state";
    }
}
