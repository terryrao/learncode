package org.raowei.test.learnjunit.chapter2;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
/**
 * ${DESCRIPTION}
 * create: 2016-07-19 14:08
 *
 * @author admin
 */
public class TestWithHamcrest {

    private List<String> values;

    @Before
    public void setUpList() {
        values = new ArrayList<>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void test1() {
        assertThat(values, CoreMatchers.hasItem(anyOf(equalTo("one"),equalTo("two"),equalTo("three"))));
    }

    @Test
    public void test2() {
        assertTrue(values.contains("one") || values.contains("two") || values.contains("three"));
    }
}
