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

package org.raowei.test.concurrents;

/**
 * @author terryrao
 * @version 1.0 6/7/2015 2:50 PM
 */
public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(this.duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + "was interrupted. " + "isInterrupted() : " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");

    }



    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sleeper", 15000),
                grumpy = new Sleeper("Grumpy",15000);
        Joiner
                joiner = new Joiner("joiner",sleeper),
                doc = new Joiner("doc",sleeper);
        grumpy.interrupt();
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper) {
        this.setName(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
