package org.raowei.test.current.notifywait;


import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 */
public class ConnectionPool {

    private final LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initial) {
        if (initial > 0) {
            for (int i = 0; i < initial; i++) {
                pool.addFirst(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addFirst(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long millis) throws InterruptedException {
        Connection result = null;
        synchronized (pool) {
            if (millis <= 0) {
                if (pool.size() <= 0) {
                    pool.wait();
                } else {
                    result = pool.removeFirst();
                }

            } else {
                long future = System.currentTimeMillis() + millis;
                long remain = millis;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = future - System.currentTimeMillis();
                }
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
            }
        }
        return result;
    }
}
