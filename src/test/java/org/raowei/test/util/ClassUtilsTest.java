package org.raowei.test.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.raowei.test.factorymethodpattern.Human;

public class ClassUtilsTest {

	@Test
	public void test() {
		Class c = Human.class;
		String packageName = c.getPackage().getName();
		System.out.println(packageName);
		fail("Not yet implemented");
	}

}
