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

import com.raowei.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @author terryrao
 * @version 1.0 6/10/2015 10:56 PM
 */
public class ProcesssingThread extends Thread{
    private static final int MAX_THREADS = 100;
    private final String ident;
    private final CountDownLatch latch;

    public ProcesssingThread(String ident, CountDownLatch latch) {
        this.ident = ident;
        this.latch = latch;
    }

    public String getIdent(){
        return ident;
    }

    public void initialize() {
        latch.countDown();
        System.out.println(ident + " : " + latch.getCount());
    }


    @Override
    public void run() {
        initialize();
    }

    public static void main(String[] args) {
        final int quorumm = 1 + MAX_THREADS/2;
        final CountDownLatch cdl = new CountDownLatch(quorumm);
        Set<ProcesssingThread> set = new HashSet<>();
        for (int i = 0; i < MAX_THREADS; i++) {
            ProcesssingThread local = new ProcesssingThread("localhost : " + (900 + i),cdl);
            set.add(local);
            local.start();
        }
        try {
            System.out.println("begin await ---");
            cdl.await();
            System.out.println("end await ---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
