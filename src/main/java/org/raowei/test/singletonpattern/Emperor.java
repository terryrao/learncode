package org.raowei.test.singletonpattern;

public class Emperor {
	//�����Լ���ʵ��
	private static Emperor emperor = null;
	
	// ˽�л�������
	private Emperor(){
		
	}
	
	public static Emperor getInstance () {
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}
	
	public  void emperorInfo(){
		System.out.println("�Ҿ���ĳĳĳ");
	}
	
}
