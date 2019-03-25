package org.raowei.test.concurrents;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {
    private static class Soldier implements Runnable {

        private String soldier;
        private CyclicBarrier barrier;

        public Soldier(String soldier, CyclicBarrier barrier) {
            this.soldier = soldier;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                this.barrier.await();
                this.doWork();
                this.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        private void doWork() throws InterruptedException {
            Thread.sleep(Math.abs(new Random().nextInt()%10000));
            System.out.println(this.soldier + " 任务完成");
        }
    }

    static class BarrierRun implements Runnable {
        private boolean flag;
        private int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令[士兵" + N + "完成任务");
            }else {
                System.out.println("集合完毕");
                flag = true;
            }
        }
    }


    public static void main(String[] args) {
        int N = 10;
        Thread[] solider = new Thread[N];
        boolean fage = false;
        CyclicBarrier barrier = new CyclicBarrier(N,new BarrierRun(fage,N));
        System.out.println("集合队伍");
        for (int i = 0; i < 10; i++) {
            System.out.println("士兵" + i + "报道");
            solider[i] = new Thread(new Soldier("士兵" + i,barrier));
            solider[i].start();

        }

    }
}
