package org.raowei.test.current.threadpool;

import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * Created by Administrator on 2017/5/9.
 */
public class MyThread implements Runnable {
    private GenericObjectPool pool;
    private volatile boolean isRun = false;
    @Override
    public void run() {
        while (!isRun) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public void destory() {
        this.isRun = true;
    }

    public void active() {

        this.isRun = false;
    }




}
