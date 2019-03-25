package org.raowei.test.concurrents;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {
    private int lock = 0;
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (this.lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
        }

        System.out.println(Thread.currentThread().getId() + " 线程退出");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new IntLock(1));
        Thread t2 = new Thread(new IntLock(2));
        t1.start();
        t2.start();
        Thread.sleep(5000);
        t2.interrupt();
    }
}
