package org.raowei.test.degin.orthogonal;

import java.util.Comparator;

/**
 * @author terryrao on 2016/7/14.
 */
public class Ordering {
    public static <T extends Comparable<? super T>> Comparator<T> natural() {
        return (t1, t2) -> t1.compareTo(t2);
    }

}
