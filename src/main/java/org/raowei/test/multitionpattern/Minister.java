package org.raowei.test.multitionpattern;

public class Minister {
	public static void main(String[] args) {
		int ministerCount = 10;
		for (int i = 0; i < ministerCount; i++) {
			Emperor emperor = Emperor.getInstance();
			emperor.getInfo();
		}
	}
}
