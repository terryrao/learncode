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

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author terryrao
 * @version 1.0 6/7/2015 10:42 AM
 */
public class MainThread {

    public static void main(String[] args) {
//        LittOff littOff = new LittOff(9);
//        littOff.run();

//        Thread t = new Thread(new LittOff(9));
//        t.start();
//        System.out.println("wait for litoff");


//        for (int i = 0; i < 5; i++) {
//            new Thread(new LittOff(9)).start();
//        }
//        System.out.println("wait for litoff");

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LittOff(9));
        }
        executorService.shutdown();
    }
}
