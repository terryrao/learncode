package org.raowei.test.concurrents;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLock {
    private static ReentrantLock lock = new ReentrantLock();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public int readHandle(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("read " + value);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void writeHandl(Lock lock, int value) {
        lock.lock();

        try {
            Thread.sleep(1000);

            this.value = value;
            System.out.println("write " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.lock();
        }
    }

    public static void main(String[] args) {
        WriteReadLock demo = new WriteReadLock();
        Runnable read = () -> {
            demo.readHandle(readLock);
            demo.readHandle(readLock);
        };
        Runnable write = () -> {
            demo.writeHandl(writeLock, new Random().nextInt());
            demo.writeHandl(writeLock, new Random().nextInt());
        };

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }


    }


}
