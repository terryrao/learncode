package highconcurrentdesign.chapter04;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author raowei
 * @date 2019-03-26
 */
public class ThreadLocalDemo2 {

    private static final int GEN_COUNT = 10000;

    private static final int THREAD_COUNT = 4;

    static ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);

    static Random random = new Random(123);

    static ThreadLocal<Random> t = ThreadLocal.withInitial(() -> new Random(123));

    static class RndTask implements Callable<Long> {
        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        @Override
        public Long call() throws Exception {
            long l = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRnd().nextInt();
            }
            long e = System.currentTimeMillis();

            System.out.println(Thread.currentThread().getName() + " speed " + (e - l) + " ms");
            return e - l;
        }

        Random getRnd() {
            if (mode == 0) {
                return random;
            } else if (mode == 1) {
                return t.get();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futures = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futures[i] = es.submit(new RndTask(0));
        }
        long totalTime = 0L;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("多线程访问同一个实例，耗时 ： " + totalTime);
        for (int i = 0; i < THREAD_COUNT; i++) {
            futures[i] = es.submit(new RndTask(1));
        }
        totalTime = 0L;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("多线程访问ThreadLocal实例，耗时 ： " + totalTime);
        es.shutdown();
    }
}
