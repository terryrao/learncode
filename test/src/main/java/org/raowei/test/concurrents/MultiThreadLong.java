package org.raowei.test.concurrents;

/**
 * 在32位机器 i 不能保证写入是一次性的
 */
public class MultiThreadLong {
    static long i = 0;

    static class WriteLong implements Runnable {
        private long l = 0;

        public WriteLong(long l) {
            this.l = l;
        }

        @Override
        public void run() {
            while (true) {
                MultiThreadLong.i = this.l;
                Thread.yield();
            }
        }
    }

    static class ReadLong implements Runnable {
        @Override
        public void run() {
            while (true) {
                long readValue = MultiThreadLong.i;
//                if (readValue != 999 && readValue != -999 && readValue != 10000 && readValue != -10000) {
                    System.out.println(readValue);
//                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new WriteLong(999)).start();
        new Thread(new WriteLong(-999)).start();
        new Thread(new WriteLong(10000)).start();
        new Thread(new WriteLong(-10000)).start();
        new Thread(new ReadLong()).start();
    }
}
