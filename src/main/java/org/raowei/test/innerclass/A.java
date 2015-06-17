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

/**
 * @author terryrao
 * @version 1.0 6/13/2015 11:28 PM
 */
public class A {
    public class B {
        // Cannot have the following declaration
//        public static int DAYS_IN_WEEK = 7;
//        //Can have a compile-time static constant field
//        public static final int DAY_IN_WEEK_2 = 7; //
//        //Cannot have the following decalaration,because it is not a
//        //compile-time constant,even though it is final
//        public static final String str = new String("hello");
    }
}

class G extends A.B {
    public G(A a) {
        a.super(); //must the first statement
    }
}
