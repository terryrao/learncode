package org.raowei.test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportIntDemo {
    static Object o = new Object();

    static ChangeObjectThread t1= new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");
    static class ChangeObjectThread extends Thread {
        String name;

        public ChangeObjectThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (o) {
                System.out.println("n : " + name);
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println("n: " + name + " 中断了");
                }
            }
            System.out.println(name + "程序结束 ");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(10000);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
