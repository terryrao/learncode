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

import org.raowei.test.pattern.builder.Update;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author terryrao
 * @version 1.0 6/10/2015 9:44 PM
 */
public class TryLock {
    Lock lock = new ReentrantLock();
    public void propagateUpdate(Update update,String backUp) {
        boolean acquired = false;
        boolean ended = false;
        while (!ended) {
            int wait = (int) (Math.random()*10);
            try {
                acquired = lock.tryLock(wait, TimeUnit.SECONDS);
                if (acquired) {
                    System.out.println("update is runnig" + update);
                    ended = confirmUpdate(update,backUp);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (acquired)
                    lock.unlock();

            }
            if (!ended) {
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean confirmUpdate(Update update,String backup) {
        boolean acquaired = false;
        boolean ended = false;
        while (!ended) {
            int wait = (int) (Math.random()*10);
            try {
                acquaired = lock.tryLock(wait,TimeUnit.SECONDS);
                if (acquaired) {
                    System.out.println("confirm update is running" + update);
                    System.out.println(backup + "is gone");
                }
                return acquaired;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (acquaired)
                    lock.unlock();
            }
        }
        return false;
    }
}
