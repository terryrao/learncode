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

import sun.applet.Main;

/**
 * @author terryrao
 * @version 1.0 6/7/2015 9:16 PM
 */
public class DualSynch {
    private Object dualObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (dualObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public static void main (String [] args) {
        DualSynch dualSynch = new DualSynch();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                dualSynch.f();
//            }
//        }).start();
        new Thread(){
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
