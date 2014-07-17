package org.raowei.test.strategy;

public class Zhaoyun {
	public static void main(String[] args) {
		Content content;
		
		System.out.println("==============第一个============");
		content = new Content(new BackDoor());
		content.operator();
		System.out.println("\n\n\n");
		
		System.out.println("=======第二个");
		content = new Content(new GivenGreenLight());
		content.operator();
		System.out.println("\n\n");
		
		System.out.println("============第三个===========");
		content = new Content(new BlockEnemy());
		content.operator();
	}
}
