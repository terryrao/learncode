/*
 * Copyright (c) 2015. [$user]
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
 * @version 1.0 6/7/2015 10:33 AM
 */
public class LittOff implements Runnable{
    protected int countDown = 0; //default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LittOff(int countDown) {
        this.countDown = countDown;
    }

    public LittOff() {
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff") + "),";
    }

}
