package org.raowei.test.factorymethodpattern;

public class BaGuaLu {
	private static BaGuaLu baGuaLu = new BaGuaLu();
	private BaGuaLu() {
		
	}
	
	public static BaGuaLu getInstance() {
		return baGuaLu;
	}
	
	public Human createHuman(Class<?> c){
		Human human = null;
		try {
			human = (Human) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException e) {
			System.out.println("����ָ��������ɫ");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("���ֶ������");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("�쵰����ָ�������ֲ�����");
			e.printStackTrace();
		}
		return human;
	}
}
