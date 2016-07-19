package org.raowei.test.learnjunit.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 10:49
 *
 * @author admin
 */
public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10 , 50);
        assertEquals(60,result,0);
    }
}
