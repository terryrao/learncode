package org.raowei.test.degin.orthogonal;

/**
 * ${DESCRIPTION}
 * create: 2016-07-13 16:00
 *
 * @author admin
 */
public interface Matcher<T> {

    boolean matches(T actual);

    static <T> Matcher<T> eq(T expected) {
        return  actual -> actual.equals(expected);
    }

    static <T> Matcher<T> ne(T expected) {
        return actual -> actual.equals(expected);
    }

}
