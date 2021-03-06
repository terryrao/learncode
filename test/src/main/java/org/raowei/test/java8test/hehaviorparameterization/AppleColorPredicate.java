package org.raowei.test.java8test.hehaviorparameterization;

import java.util.function.Predicate;

/**
 * @author raow
 * @version 2015-09-16
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public class AppleColorPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        if (apple.getColor().equals("red")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
