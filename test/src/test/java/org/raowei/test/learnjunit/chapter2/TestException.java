package org.raowei.test.learnjunit.chapter2;

import org.junit.Test;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 11:40
 *
 * @author admin
 */
public class TestException {

    @Test(expected = NullPointerException.class)
    public void testGetHandlerNotDefined() {
        if (false) {
            throw new NullPointerException("空指针");
        }
    }
}
