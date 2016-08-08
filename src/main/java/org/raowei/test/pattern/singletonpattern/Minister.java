package org.raowei.test.pattern.singletonpattern;

public class Minister {
	public static void main(String[] args) {
		Emperor emperor1 = Emperor.getInstance();
		emperor1.emperorInfo();
		Emperor emperor2 = Emperor.getInstance();
		emperor2.emperorInfo();
		
	}
}
