package org.raowei.test.util;

import org.junit.Test;
import org.raowei.test.factorymethodpattern.Human;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	@Test
	public void testDoubleIterator () {
		List<String> names = new ArrayList<>();
		names.add("Josh");
		names.add("Jim");
		List<String> address = new ArrayList<>();
		address.add("1111");
		address.add("2222");
		Iterator<String> n = names.iterator();
		Iterator<String> a = address.iterator();

		while (n.hasNext() && a.hasNext()) {
			System.out.println(n.next() + "lives at " + a.next());
		}

	}

	@Test
	public void testIncrement() {
		int i = 0;
		int j = 0;
		int[] a = new int[]{1,2};
		System.out.println("a[i++]" + a[i++]); //先读值，改变值
		System.out.println("a[++j]" + a[++j]); // 先改变值，再读值
		System.out.println("i " + i);
		System.out.println("j " + j);
	}

	@Test
	public void testNumberOfLeadingZeros() {
		int i = 1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("数字 " + i + " 的二进制位前面有：" + Integer.numberOfLeadingZeros(i) + " 个零");
	}



}
