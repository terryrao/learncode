package org.raowei.test.concurrents;


/**
 * 测试 volatile
 */
public class CountThread {
    static volatile int i = 0;

    static class  Plus implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                i ++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[10];
        for (int i1 = 0; i1 < t.length; i1++) {
            t[i1] = new Thread(new Plus());
            t[i1].start();
        }

        for (int i1 = 0; i1 < t.length; i1++) {
            t[i1].join();
        }

        System.out.println(i);
    }
}
