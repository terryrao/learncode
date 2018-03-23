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
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author terryrao
 * @version 1.0 6/8/2015 9:09 PM
 */
public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new Entrance(i));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
            Entrance.canel();
            service.shutdown();
            if (!service.awaitTermination(250,TimeUnit.MILLISECONDS))
                System.out.println("Some tasks were not terminated");
            System.out.println("Total : " + Entrance.getTotalCount());
            System.out.println("Sum of Entrances : " + Entrance.sumEntrances());



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class Count {
    private int count = 0;
    private Random random  = new Random(47);
    public  int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++ temp);
    }

    public synchronized int value (){
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> list = new ArrayList<>();
    private int number;
    private final int id;
    private static volatile boolean caneled = false;

    public Entrance(int id) {
        this.id = id;
        list.add(this);
    }


    @Override
    public void run() {
        while (!caneled) {
            synchronized (this) {
                ++ number;
            }
            System.out.println(this + "Total : " + count.increment());

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("stopping " + this);
    }

    public static void canel() {
        caneled = true;
    }
    @Override
    public String toString() {
        return "Entrance{" +
                "id=" + id +
                '}';
    }
    public static int getTotalCount() {
        return count.value();
    }


    public int getValue () {
        return number;
    }

    public static int sumEntrances () {
        int sum = 0;
        for (Entrance entrance : list) {
            sum += entrance.getValue();
        }
        return sum;
    }
}
