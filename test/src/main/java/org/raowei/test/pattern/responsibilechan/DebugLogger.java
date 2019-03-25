package org.raowei.test.pattern.responsibilechan;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 19:55
 *
 * @author admin
 */
public class DebugLogger extends AbstractLogger {
    public DebugLogger() {
        this.level = DEBUG;
        this.setNextLogger(new ErrorLogger());
    }

    @Override
    void write(String message) {
        System.out.println("[debug out] : " + message);
    }
}
