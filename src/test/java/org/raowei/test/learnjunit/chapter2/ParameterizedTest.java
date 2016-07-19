package org.raowei.test.learnjunit.chapter2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.raowei.test.learnjunit.chapter1.Calculator;

import java.util.Arrays;
import java.util.Collection;

/**
 * 批量参数化测试
 * create: 2016-07-19 11:01
 *
 * @author admin
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][]{{2, 1, 1}, {3, 2, 1}, {4, 3, 1}});
    }

    public ParameterizedTest(double expected,double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
        Calculator calc = new Calculator();
        Assert.assertEquals(expected,calc.add(valueOne,valueTwo),0);
    }
}
