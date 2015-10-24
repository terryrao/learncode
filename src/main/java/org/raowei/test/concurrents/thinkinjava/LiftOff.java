package org.raowei.test.concurrents.thinkinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author raow
 * @version 2015-09-21
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public class LiftOff implements Runnable {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount ++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- >0) {
            System.out.print(status());
//            Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }*/

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        System.out.println("靠谱吗？");
        executorService.shutdown();

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        System.out.println("单线程？");
        executorService.shutdown();*/


    }
}
