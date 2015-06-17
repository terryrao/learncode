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

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author terryrao
 * @version 1.0 6/11/2015 8:07 PM
 */
public class CopyOnWriteListTest {

    public  static class ReadTask implements Runnable{
        private List<String> list;

        public ReadTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static  class WriteTask implements Runnable {
        private List<String> list;
        private int index;


        public WriteTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public void run() {
//            list.remove(index);
            list.add(index,"write : " + index);

        }
    }

    public void run () {
        final  int num  = 10;
//        List<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add("Main_" + i);
        }
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i< num ; i++) {
            exe.execute(new WriteTask(list,num));
            exe.execute(new ReadTask(list));
        }
        exe.shutdown();
    }

    public static void main(String[] args) {
//        new CopyOnWriteListTest().run();
        Class aClass = MethodHandles.lookup().lookupClass();
        System.out.println(aClass.getName());
    }
}
