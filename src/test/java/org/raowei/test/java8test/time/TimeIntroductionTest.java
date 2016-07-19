package org.raowei.test.java8test.time;

import org.junit.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by terryrao on 5/15/2015.
 */
public class TimeIntroductionTest {

    @Test
    public void  test() {
        TimeIntroduction.testClock();
    }

    @Test
    public void test2() {
        int count = Stream.of(1,2,3).reduce(0,(acc,element) -> acc + element);
        assertEquals(6, count);

        BinaryOperator<Integer> accmulator = (acc,element) -> acc + element;

        int count2 = accmulator.apply(accmulator.apply(accmulator.apply(0,1),2),3);
        assertEquals(count,count2);

        Optional<Object> empty = Optional.empty();
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(empty.isPresent());
        System.out.println(o.isPresent());
        assertEquals("b",empty.orElse("b"));
        assertEquals("c",empty.orElseGet(() -> "c"));
    }
}