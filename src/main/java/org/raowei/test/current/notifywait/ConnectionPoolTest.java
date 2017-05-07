package org.raowei.test.current.notifywait;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);

    private static CountDownLatch start = new CountDownLatch(1);

    private static CountDownLatch end ;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(got,notGot,count),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total Invoked: " + threadCount * count);
        System.out.println("get connection : " + got);
        System.out.println("notGet connection : " + notGot);

    }


    static class ConnectionRunner implements Runnable {
        private AtomicInteger got;
        private AtomicInteger notGet;
        int count;

        public ConnectionRunner(AtomicInteger got, AtomicInteger notGet, int count) {
            this.got = got;
            this.notGet = notGet;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException ignored) {
            }

            while (count > 0 ) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();

                        }finally {
                            pool.releaseConnection(connection);
                        }
                        this.got.incrementAndGet();
                    }else {
                        notGet.incrementAndGet();
                    }
                } catch (InterruptedException | SQLException ignored) {
                } finally {
                    count --;
                }

            }
            end.countDown();
        }
    }

}
