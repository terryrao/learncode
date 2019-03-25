package org.raowei.test.java8test.hehaviorparameterization;


import java.util.ArrayList;
import java.util.List;

/**
 * @author terryrao
 * @version 2015-09-16
 * @since 1.0
 */
public class TestMethod {


    public static void testPredicate() {
        List<Apple> apples = getList();



    }

    private static void testFilter() {

    }

    private static List<Apple> getList() {
        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setColor("yellow");
        apple1.setWeight(160);

        Apple apple2 = new Apple();
        apple2.setColor("red");
        apple2.setWeight(130);

        Apple apple3 = new Apple();
        apple3.setColor("green");
        apple3.setWeight(160);

        return apples;
    }
}
