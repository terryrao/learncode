package org.raowei.test.concurrents;

public class NoVisibility {
    static volatile boolean ready =false;
    static  int number = 0;

    static class Task extends Thread {
        @Override
        public void run() {
            while (!ready) {
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Task().start();
        Thread.sleep(1000);
        ready = true;
        number = 100;
        Thread.sleep(20000);
    }

}
