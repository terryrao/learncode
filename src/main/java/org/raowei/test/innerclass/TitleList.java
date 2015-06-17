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

package org.raowei.test.innerclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author terryrao
 * @version 1.0 6/13/2015 11:55 AM
 */
public class TitleList {
    private List<String> list = new ArrayList<>();

    public void add(String title) {
        list.add(title);
    }

    public boolean remove (String title) {
        return list.remove(title);
    }

    public Iterator<String> iterator() {

        return new Iterator<String>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < list.size();
            }

            @Override
            public String next() {
                String title = list.get(count);
                count++;
                return title;
            }
        };

    }

    public static void main(String[] args) {
        TitleList list = new TitleList();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
