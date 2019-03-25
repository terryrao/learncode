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

package org.raowei.test.java8test;

import org.raowei.test.java8test.lamda.Sensitive;
import org.raowei.test.java8test.lamda.StringToIntMapper;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 11:06 AM
 */
public class LamdaTest {
    public static void main(String[] args) {
//        StringToIntMapper mapper = (String str) -> str.length();
//        String name = "raowei";
//        int length = mapper.map(name);
//        System.out.println("name : " + name + " length : " + length);

//        Sensitive sen =(String str) -> str.length(); //compile-time error;
        //intersection type
        Sensitive sensitive = (Sensitive & StringToIntMapper) (str) -> str.length();
    }
}
