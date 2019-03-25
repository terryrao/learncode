package org.raowei.test.concurrents;

public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        // interrupt 只是将线程设置为中断状态，不会真正中断线程，线程的中断需要自己实现
/*
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                }
            }
        };
        thread.start();
        Thread.sleep(20000);
        thread.interrupt();
        System.out.println("interrupt is executed");*/

        // 中断的逻辑需要自己实现
       /* Thread t = new Thread(() -> {
            while (true) {
                Thread.yield();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("OK  I will stop");
                    return;
                }
            }
        });

        t.start();
        Thread.sleep(10000);
        t.interrupt();
        System.out.println("interrupt is executed");*/
       //睡眠中断
        Thread t = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(" ok interrupted");
                    break;
                }
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    //中断后再次设置为异常状态，如果不在这里再次中断，不会走上面的中断逻辑
                    System.out.println("Interrupted when sleep");
                    Thread.currentThread().interrupt();
                    e.printStackTrace();

                }
                Thread.yield();


            }
        });

        t.start();
        Thread.sleep(10000);
        t.interrupt();

    }
}
