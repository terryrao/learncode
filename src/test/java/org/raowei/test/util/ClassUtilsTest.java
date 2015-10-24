package org.raowei.test.util;

import org.junit.Test;
import org.raowei.test.factorymethodpattern.Human;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.fail;

public class ClassUtilsTest {

	@Test
	public void test() {
		Class<?> c = Human.class;
		String packageName = c.getPackage().getName();
		System.out.println(packageName);
		fail("Not yet implemented");
	}

	@Test
	public void testif() {
		int x = 3;
		if (x == 3) {
			System.out.println("x == 3");
		}else if (x==3 || x==4) {
			System.out.println("x==3 || x==4");
		}else if ( x != 4) {
			System.out.println("x !=4");
		}
	}

	@Test
	public  void testTime() {
		Date date = new Date(1443888000000L);
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(timeFormat.format(date));
	}

}
