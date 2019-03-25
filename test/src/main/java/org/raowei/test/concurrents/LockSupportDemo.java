package org.raowei.test.concurrents;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    static Object o = new Object();
    static ChangeObject t1 = new ChangeObject("t1");
    static ChangeObject t2 = new ChangeObject("t2");


    static class ChangeObject extends Thread{
        private String name;

        public ChangeObject(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (o) {
                System.out.println("n: " + this.name);
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(10000);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t2.join();
        t2.join();
    }
}
