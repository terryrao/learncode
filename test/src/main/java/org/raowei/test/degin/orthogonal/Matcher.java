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

    /**
     * 可以消除重复
     * @param expected
     * @param <T>
     * @return
     */
    static <T extends Comparable<? super T>> Matcher<T> gt(T expected) {
        return actual -> Ordering.<T>natural().compare(actual,expected) > 0;
    }

    static <T extends Comparable<? super T>> Matcher<T> lt(T expected) {
        return actual -> Ordering.<T>natural().compare(actual,expected) < 0;
    }

    static <T extends Comparable<? super T>> Matcher<T> gt1(T expected) {
        return  actual -> compare(actual,expected) > 0;
    }

    static <T extends Comparable<? super T>> Matcher<T> lt2(T expected)
    {
        return actual -> compare(actual,expected) < 0;
    }    static <T extends Comparable<? super T >> int compare(T t1, T t2) {
        return Ordering.<T>natural().compare(t1,t2);
    }

}
