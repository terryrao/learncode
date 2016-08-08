package org.raowei.test.pattern.singletonpattern;

public class Emperor {
	//持有自己的实例
	private static Emperor emperor = null;
	
	// 私有化构造器
	private Emperor(){
		
	}
	
	public static Emperor getInstance () {
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}
	
	public  void emperorInfo(){
		System.out.println("我就是某某某");
	}
	
}
