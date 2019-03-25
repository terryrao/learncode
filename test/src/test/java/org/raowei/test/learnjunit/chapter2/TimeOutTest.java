package org.raowei.test.learnjunit.chapter2;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 11:46
 *
 * @author admin
 */
public class TimeOutTest {

    // 毫秒级
    //忽略测试 只有在套件里测试时才有效
    @Ignore(value = "ignore for now until we decide a decent time-limit")
    @Test(timeout = 130)
    public void testTimeOut() throws InterruptedException {
//        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
    }
}
