/*
 * Copyright (c) 2015. [${USER}]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.raowei.test.concurrents.shareresources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author terryrao
 * @version 1.0 6/7/2015 8:18 PM
 */
public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public void incrementX() {
        this.x++;
    }

    public int getY() {
        return y;
    }

    public void incrementY() {
        this.y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair values not equals : " + Pair.this);
        }

    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }

    public static void main(String[] args) {
        PairManger pm1 = new pairManager3();
        PairManger pm2 = new pairManager4();
        CriticalSection.testApproaches(pm1,pm2);
    }

}

abstract class PairManger {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    // make a copy to keep original safe
    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();

}

// Synchronize the entire method
class pairManager1 extends PairManger {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }

}

//use a critical section
class PairManager2 extends PairManger {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

// use Lock and Synchronize entire method
class pairManager3 extends PairManger {
    private Lock lock = new ReentrantLock();
    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }

    }

}

// use Lock
class pairManager4 extends PairManger {
    private Lock lock = new ReentrantLock();
    @Override
    public  void increment() {
        lock.lock();
        Pair temp;
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }finally {
            lock.unlock();
        }
        store(temp);
    }
}


class PairManipulator implements Runnable {
    private PairManger pm;

    public PairManipulator(PairManger pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair : " + pm.getPair() + "checkCountor " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {

    private PairManger pm;

    public PairChecker(PairManger pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

class CriticalSection {
    static void testApproaches(PairManger pman1, PairManger manger2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(manger2);
        PairChecker checker1 = new PairChecker(pman1),
                checker2 = new PairChecker(manger2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(checker1);
        executorService.execute(checker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("pm1 " + pm1 + " \npm2 : " + pm2);
        System.exit(0);
    }

}