package org.raowei.test.java8test.functional;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @author raowei
 * @date 2019-03-29
 */
public class TestCompator {

    public static void main(String[] args) {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

        humans.sort(Comparator.comparing(Human::getName));
        humans.forEach(System.out::println);
        //反转
        humans.sort(Comparator.comparing(Human::getName).reversed());

        humans.forEach(System.out::println);

        multiSort();
    }

    private static void multiSort() {
        System.out.println("-----------");
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        humans.forEach(System.out::println);
    }
}
