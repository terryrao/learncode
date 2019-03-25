package org.raowei.test.java8test.lamda.repeatAnnotation;

import java.lang.annotation.Repeatable;

/**
 * Created by terryrao on 5/15/2015.
 */
@Repeatable(Authorities2.class)
public @interface Authority2 {
    String role();
}
