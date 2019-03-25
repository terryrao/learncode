package highconcurrentdesign.chapter03;

import java.util.concurrent.*;

/**
 * ThreadPoolExecutor demo
 *
 * @author raowei
 * @date 2019-03-25
 */
public class ExtTreadPool {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                Task futureTask = (Task) r;
                System.out.println("准备执行：" + futureTask.name);

            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                Task futureTask = (Task) r;
                System.out.println("执行结束: " + futureTask.name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }

        };
        for (int i = 0; i < 5; i++) {
            Task task = new Task("task - " + i);
            executor.execute(task);
            TimeUnit.SECONDS.sleep(10);
        }
        executor.shutdown();
    }


    private static class Task implements Runnable {

        public Task(String name) {
            this.name = name;
        }

        private String name;

        @Override
        public void run() {
            System.out.println("正在运行 ： thread name = " + name);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
