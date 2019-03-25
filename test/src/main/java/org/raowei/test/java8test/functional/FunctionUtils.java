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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 1:06 PM
 */
public class FunctionUtils {
    public static <T> void forEach(List<T> list,Consumer<? super T> consumer) {
        for(T t : list ) {
           consumer.accept(t);
        }
        //list.forEach(consumer::accept);
    }

    public static <T> List<T> filter(List<T> list,Predicate<? super T> predicate) {
       List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static <T,R> List<R> map(List<T> list,Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }

    public static void main(String[] args) {
        List<Persion> list = Persion.getPersions();
        System.out.println("original list of persions:");
        FunctionUtils.forEach(list,p -> System.out.println(p));

        //Filter Male
        List<Persion> males = FunctionUtils.filter(list, persion -> persion.getGender() == Gender.MALE);
        System.out.println("male only");
        FunctionUtils.forEach(males, p -> System.out.println(p));

        //Map each persion to his/her year of birth
        List<Integer> dobyeaList = FunctionUtils.map(list,p -> p.getDob().getYear());
        System.out.println("Map each persion to his/her year of birth");
        FunctionUtils.forEach(dobyeaList, year -> System.out.println(year));

        //
        Function<Integer,String> func1 = x -> Integer.toBinaryString(x);
        System.out.println(func1.apply(17));
        Function<Integer,String> func2 = Integer::toBinaryString;
        System.out.println(func2.apply(17));
        BiFunction<Integer,Integer,Integer> func3 = Integer::sum;
        System.out.println(func3.apply(12, 13));

        list.sort(Comparator.comparing(Persion::getFirstName));
        System.out.println("print sort list-->");
        System.out.println("sort by firstName");
        FunctionUtils.forEach(list,System.out::println);

        //sort using the last Name ,first name, and the DOB
        list.sort(Comparator.comparing(Persion::getLastName).thenComparing(Persion::getFirstName).thenComparing(Persion::getDob));
        FunctionUtils.forEach(list,System.out::println);
    }
}
