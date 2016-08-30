package org.raowei.test;

import org.junit.Test;

import java.sql.Time;
import java.util.Arrays;

/**
 * ${DESCRIPTION}
 * create: 2016-08-24 9:57
 *
 * @author admin
 */
public class other {

    @Test
    public void test2 () {
        System.out.println(new Time(30000));
        System.out.println(new Time(0,0,30));
    }
    @Test
    public void test() {
        System.out.println(Arrays.toString("\uE6A6".getBytes()));
    }
}
