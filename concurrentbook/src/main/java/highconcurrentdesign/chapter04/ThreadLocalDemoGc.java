package highconcurrentdesign.chapter04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author raowei
 * @date 2019-03-26
 */
public class ThreadLocalDemoGc {

    static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is gc");
        }
    };

    static volatile CountDownLatch latch = new CountDownLatch(10000);

    static class ParseDate implements Runnable {
        private int i;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if (tl.get() == null) {
                tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println(this.toString() + "is gc");
                    }
                });
            }

            System.out.println(Thread.currentThread().getId() + ":created SimpleDateFormat ");
            try {
                Date date = tl.get().parse("2019-03-26 19:29:" + i % 60);

            } catch (ParseException e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i <= 10000; i++) {
            executor.submit(new ParseDate(i));
        }

        latch.await();

        System.out.println("mission complete");

        tl = null;
        System.gc();
        System.out.println("First gc complete!!");

        tl =  new ThreadLocal<>();
        latch = new CountDownLatch(10000);
        for (int i = 0; i <= 10000; i++) {
            executor.submit(new ParseDate(i));
        }

        latch.await();
        TimeUnit.SECONDS.sleep(10);
        System.gc();
        System.out.println("Second Gc completed");
    }
}
