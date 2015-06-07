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

/**
 * @author terryrao
 * @version 1.0 6/7/2015 4:17 PM
 */
public class CheckEvent implements  Runnable{
    private int id;
    private IntGenerator generator;

    public CheckEvent(int id, IntGenerator generator) {
        this.id = id;
        this.generator = generator;
    }
    @Override
    public void run() {
        while (!generator.isCaneled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                System.out.println(val + " not event");
                generator.canel();
            }
        }
    }

    public static void test(IntGenerator generator,int count) {
        System.out.println("Press Control-c to exit");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new CheckEvent(count,generator));
        }
        service.shutdown();
    }

    public static void test(IntGenerator intGenerator) {
        test(intGenerator,10);
    }
}
