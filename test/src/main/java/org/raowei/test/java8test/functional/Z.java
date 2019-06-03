package org.raowei.test.java8test.functional;

import com.google.common.base.Function;

import java.util.function.Consumer;

/**
 * @author raowei
 * @date 2019-04-15
 */
public class Z {

    public static void main(String[] args) {
        Object o = (I & J) () -> {
        };

        Consumer<String> consumer = System.out::println;
        consumer.accept("this is Major Torn");
        Function<Integer, Integer> abs = Math::abs;
        System.out.println(abs.apply(-11));
    }

}

interface I {
    void foo();

}

interface J {
    void foo();
}
