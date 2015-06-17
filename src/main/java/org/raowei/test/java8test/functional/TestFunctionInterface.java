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

package org.raowei.test.java8test.functional;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 12:12 PM
 */
public class TestFunctionInterface {
    public static void main(String[] args) {
//        Function<Integer,Integer> square1 = x-> x*x;
//        System.out.println(square1.apply(12));
//
//        IntFunction<Integer> square2 = x -> x*x;
//        System.out.println(square2.apply(12));
//
//        ToIntFunction<Integer> square3 = x -> x*x;
//        System.out.println(square3.applyAsInt(13));
        long num = 5L;
        Function<Long,Long> square = x -> x*x;
        Function<Long,Long> addOne = x -> x+1;
        Function<Long,Long> squareAddOne = square.andThen(addOne);
        System.out.println(squareAddOne.apply(num));

        Function<Long,Long> addOnesquare = addOne.compose(square);
        System.out.println(addOnesquare.apply(num));

        //compose to them
        Function<Long,Long> chainedFunction = ((Function<Long,Long>)(x -> x*x)).andThen(x -> x+1).compose( x -> x*x);
        System.out.println(chainedFunction.apply(3L));
    }
}
