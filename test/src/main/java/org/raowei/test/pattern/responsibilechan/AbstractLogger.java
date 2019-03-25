package org.raowei.test.pattern.responsibilechan;

/**
 * ${DESCRIPTION}
 * create: 2016-07-28 19:47
 *
 * @author admin
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;

    private AbstractLogger nextLogger;

    public void sendMessage(int level,String message) {
        if (level <= this.level) {
            write(message);
        }else {
            this.nextLogger.sendMessage(level,message);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    abstract void write(String message);
}
