package highconcurrentdesign.chapter04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author raowei
 * @date 2019-03-26
 */
public class AtomicIntegerDemo {

    private static AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
       Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    i.incrementAndGet();
                }
            });
        }

        for (int j = 0; j < 10; j++) {
            threads[j].start();
        }
        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }
        System.out.println(i.get());
    }
}
