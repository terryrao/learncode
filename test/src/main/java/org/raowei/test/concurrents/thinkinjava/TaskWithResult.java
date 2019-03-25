package org.raowei.test.concurrents.thinkinjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author raow
 * @version 2015-09-21
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public class TaskWithResult implements Callable<String> {
    private int id ;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
            System.out.println("执行" + i);
        }
        System.out.println(futures.size());
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}


