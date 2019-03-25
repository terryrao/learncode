package highconcurrentdesign.chapter03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author raowei
 * @date 2019-03-25
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(Thread.currentThread().getName())));
    }

    private Exception clientTrace(String msg) {
        return new Exception("client trace Exception, thread: " + msg);
    }

    private Runnable wrap(Runnable runnable, final Exception ex) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                ex.printStackTrace();
                throw e;
            }
        };
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new TraceThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            executor.execute(new DivTask(100,i));
        }
        executor.shutdown();
    }
}
