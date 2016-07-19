package org.raowei.test.learnjunit.chapter2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.raowei.test.learnjunit.chapter1.CalculatorTest;

/**
 * 测试套件
 * create: 2016-07-19 11:30
 *
 * @author admin
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {CalculatorTest.class,ParameterizedTest.class,TimeOutTest.class})
public class MasterTestSuite {
}
