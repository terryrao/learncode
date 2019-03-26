package highconcurrentdesign.chapter04;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author raowei
 * @date 2019-03-26
 */
public class AtomicIntegerFeildUpdateDemo {

    static class Candidate {
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    public static AtomicInteger allScore = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[1000];
        Candidate candidate = new Candidate();
        for (int i = 0; i < 1000; i++) {
            t[i] = new Thread(() -> {
                if (Math.random() > 0.4) {
                    scoreUpdate.incrementAndGet(candidate);
                    allScore.incrementAndGet();
                }
            });
            t[i].start();
        }
        for (int i = 0; i < 1000; i++) {
            t[i].join();
        }
        System.out.println("score = " + candidate.score);
        System.out.println("all score = " + allScore.get());
    }
}
