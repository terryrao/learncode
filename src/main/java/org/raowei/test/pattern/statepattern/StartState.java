package org.raowei.test.pattern.statepattern;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:04
 *
 * @author admin
 */
public class StartState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "start state";
    }
}
