package org.raowei.test.pattern.responsibilechan;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 19:52
 *
 * @author admin
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        this.level = INFO;
        this.setNextLogger(new DebugLogger());
    }

    @Override
    void write(String message) {
        System.out.println("[info out] : " + message);
    }
}
