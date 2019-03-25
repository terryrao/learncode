package org.raowei.test.concurrents;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable{
    private static CountDownLatch end = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("ok done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new CountDownLatchDemo());
        }

        try {
            end.await();
            System.out.println("fire!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
