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

import java.io.IOException;

/**
 * @author terryrao
 * @version 1.0 6/7/2015 3:13 PM
 */
public class ResponseAble extends Thread {
    private static volatile double d = 1;
    public  ResponseAble() {
        setDaemon(true);
        start();
    }
    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
    public static void main (String[] args) {
        ResponseAble a = new ResponseAble();
        try {
            System.in.read();
            System.out.println(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UnsponseAble {
    private static volatile double d = 1;
    public  UnsponseAble() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
//        try {
//            int read = System.in.read();
//            read = 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void run() {

    }
}