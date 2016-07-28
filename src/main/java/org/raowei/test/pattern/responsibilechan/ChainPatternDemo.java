package org.raowei.test.pattern.responsibilechan;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 20:01
 *
 * @author admin
 */
public class ChainPatternDemo {

    public static void main(String[] args) {
        AbstractLogger logger = new InfoLogger();
        logger.sendMessage(AbstractLogger.ERROR, "debug message");
    }
}
