package highconcurrentdesign.chapter06;

import java.util.concurrent.locks.StampedLock;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class StampedLockDemo {

    private double a, b;

    private StampedLock lock = new StampedLock();

    public void write(int a, int b) {
        long stamp = lock.writeLock();
        try {
            this.a += a;
            this.b += b;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public double read() {
        //乐观锁获取
        long stamp = lock.tryOptimisticRead();
        double currentA = a;
        double currentB = b;
        //查看中间是否有改变过值
        if (!lock.validate(stamp)) {
            //升级为悲观锁
            stamp = lock.readLock();
            try {
                currentA = a;
                currentB = b;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentA * currentA + currentB * currentB);
    }


}
