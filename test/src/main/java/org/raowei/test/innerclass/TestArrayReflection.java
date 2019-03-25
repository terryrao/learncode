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

/**
 * @author terryrao
 * @version 1.0 6/14/2015 10:37 AM
 */
public class TestArrayReflection {
    public static void main(String[] args) {
        int[][][] ints = new int[6 ][3][2];
        System.out.println("int[][][] dimension is " +getArrayDimension(ints));
    }

    public static int getArrayDimension(Object array) {
        int dimension = 0;
        Class<?> c = array.getClass();
        System.out.println(c.getName());
        if (!c.isArray()) {
            throw new IllegalArgumentException("Object is not array");
        }
        while (c.isArray()) {
            dimension++;
            c = c.getComponentType();
        }
        return dimension;
    }

}
