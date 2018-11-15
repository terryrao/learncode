package org.raowei.test.concurrents;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            condition.await();
            System.out.println("well done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReentrantLockCondition());
        t1.start();
        Thread.sleep(5000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
