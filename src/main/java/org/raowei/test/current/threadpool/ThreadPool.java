package org.raowei.test.current.threadpool;

/**
 */
public interface ThreadPool<Job extends Runnable> {
    void execute (Job job);

    void shutdonw();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();

}



