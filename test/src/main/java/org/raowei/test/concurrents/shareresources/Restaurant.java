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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author terryrao
 * @version 1.0 6/9/2015 7:51 PM
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    waitePersion waitePersion = new waitePersion(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(waitePersion);
        exec.execute(chef);

    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class waitePersion implements Runnable {
    private Restaurant restaurant;

    public waitePersion(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                while (restaurant.meal == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("wait interrupted");
                    }
                }
                System.out.println("waitPersion got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                while (restaurant.meal != null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Chef interrupted");
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up!");
                synchronized (restaurant.waitePersion) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitePersion.notifyAll();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }


}
