package org.raowei.test.concurrents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemahoreDemo implements Runnable {
    Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "done");
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SemahoreDemo semahoreDemo = new SemahoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(semahoreDemo);
        }
    }
}
