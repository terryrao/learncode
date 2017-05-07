package org.raowei.test.current.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private final LinkedList<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_WORKER_SIZE = 20;
    private static final int MIN_WORK_SIZE = 1;
    private static final int DEFAULT_WORKER_SIZE = 10;

    private int workNum = DEFAULT_WORKER_SIZE;

    private AtomicLong threadNum = new AtomicLong();

    @Override
    public void execute(Job job) {
        synchronized (jobs) {
            if (job != null) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdonw() {
        synchronized (jobs) {
            for (Worker worker : workers) {
                if (worker != null) {
                    worker.shutdown();
                }
            }
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (workers) {

            if (num <= 0) {
                return;
            }
            int addnum = 0;
            int size = workNum + num;
            if (size > MAX_WORKER_SIZE) {
                size = MAX_WORKER_SIZE;
                addnum = MAX_WORKER_SIZE - workNum;

            } else {
                addnum = num;
            }

            initThreadPool(addnum);
            this.workNum = size;
        }

    }


    private void initThreadPool(int addNum) {
        for (int i = 0; i < addNum; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum);
            threadNum.incrementAndGet();
            thread.start();
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num < 0 || this.workNum < num) {
                throw new IllegalArgumentException(String.format("beyond workNum %s", num));
            }
            int count = 0;
            while (num > count) {
                Worker worker = workers.get(count);
                if (worker != null) {
                    worker.shutdown();
                }
                workers.remove(count);
                count++;
            }
            this.workNum -= count;

        }
    }

    @Override
    public int getJobSize() {
        return 0;
    }


    public DefaultThreadPool() {
        this(DEFAULT_WORKER_SIZE);
    }

    public DefaultThreadPool(int initial) {
        workNum = initial > MAX_WORKER_SIZE ? MAX_WORKER_SIZE : initial < MIN_WORK_SIZE ?
                MIN_WORK_SIZE : initial;
        this.initThreadPool(workNum);
    }

    class Worker implements Runnable {
        private boolean isWork = true;

        @Override
        public void run() {
            synchronized (jobs) {
                while (!isWork) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException ignored) {
                        }

                    }
                    Job job = jobs.removeFirst();
                    if (job != null) {
                        job.run();
                    }
                }

            }

        }

        public void shutdown() {
            isWork = false;
        }
    }
}
