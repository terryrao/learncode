package org.raowei.test.concurrents;

public class JoinMain {

    static volatile int i;
    public static class AddThread extends Thread {
        @Override
        public void run() {
            for ( i = 0; i < 10000; i++) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new AddThread();
        t.start();
        t.join(); // 等待 t 线程执行完
        System.out.println(i);
    }

}
