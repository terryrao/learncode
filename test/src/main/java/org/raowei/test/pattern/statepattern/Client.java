package org.raowei.test.pattern.statepattern;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 17:11
 *
 * @author admin
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        State start = new StartState();
        start.doAction(context);
        System.out.println(context.getState().toString());

        State stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
