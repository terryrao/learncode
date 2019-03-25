package highconcurrentdesign.chapter03;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author raowei
 * @date 2019-03-25
 */
public class ForkJoinTask extends RecursiveTask<Long> {
    private long start;
    private long end;
    private final long Threshold = 1000L;

    public ForkJoinTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        boolean fork = end - start < Threshold;
        if (fork) {
            long step = (end - start) / 100;
            ArrayList<ForkJoinTask> list = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long last = pos + step;
                if (last > end) last = end;

                ForkJoinTask forkJoinTask = new ForkJoinTask(pos, last);
                list.add(forkJoinTask);
                pos = last + 1;
                forkJoinTask.fork();
            }
            for (ForkJoinTask task : list) {
                sum += task.join();
            }
        } else {
            for (int i = 0; i < end; i++) {
                sum += i;
            }

        }
        return sum;

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask task = new ForkJoinTask(0,200000L);
        java.util.concurrent.ForkJoinTask<Long> submit = pool.submit(task);
        Long result = submit.get();
        System.out.println(result);
        System.out.println("n(n-1) /2 = " + 200000L*(200000L -1 )/2);
    }
}
