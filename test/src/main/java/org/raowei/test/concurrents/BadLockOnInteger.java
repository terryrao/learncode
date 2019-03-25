package org.raowei.test.concurrents;

public class BadLockOnInteger implements Runnable{
    static Integer i = 0;

    static BadLockOnInteger instance  = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            synchronized (i) { // 每次赋值后 i 实际上是一个新的对像，因此锁不是同一个实例，正确的方式是获取 instance 的锁
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BadLockOnInteger());
        Thread t2 = new Thread(new BadLockOnInteger());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
