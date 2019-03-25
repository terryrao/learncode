package highconcurrentdesign.chapter03;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author raowei
 * @date 2019-03-25
 */
public class DivTask implements Runnable {
    private int a;
    private int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println(a / b);
    }


    public static void main(String[] args) {
        //当 i = 0 时 会出现错误，但不会输出日志，需要注意
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            executor.submit(new DivTask(100,i));
            // execute 方法会部分抛出异常，但不全面
//            executor.execute(new DivTask(100,i));
        }
        executor.shutdown();
    }

}
