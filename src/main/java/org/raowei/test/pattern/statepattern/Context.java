package org.raowei.test.pattern.statepattern;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:03
 *
 * @author admin
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
