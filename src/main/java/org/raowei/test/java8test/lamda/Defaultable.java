package org.raowei.test.java8test.lamda;

/**
 * Created by terryrao on 5/15/2015.
 */
public interface Defaultable {
    default void defaultMethod () {
        System.out.println("defautl method");
    }

    String method();
}
