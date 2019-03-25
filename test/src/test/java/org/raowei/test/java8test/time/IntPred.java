package org.raowei.test.java8test.time;

import java.util.function.Predicate;

/**
 * ${DESCRIPTION}
 * create: 2016-07-18 12:00
 *
 * @author admin
 */
public interface IntPred {

    boolean test(Integer value);
}


interface testPred {
    boolean check(Predicate<Integer> predicate);
//    boolean check(IntPred intPred);
}

class PredClass implements testPred {

    private boolean re;
    private int a;
    public static void main(String[] args) {

    }

    @Override
    public boolean check(Predicate<Integer> predicate) {
        return predicate.test(a);
    }

//    @Override
//    public boolean check(IntPred intPred) {
//        return intPred.test(a);
//    }
}