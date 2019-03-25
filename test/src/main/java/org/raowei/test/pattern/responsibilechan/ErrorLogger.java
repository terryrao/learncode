package org.raowei.test.pattern.responsibilechan;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 19:59
 *
 * @author admin
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger() {
        this.level = ERROR;
    }


    @Override
    void write(String message) {
        System.out.println("[error out]: " + message);
    }
}
