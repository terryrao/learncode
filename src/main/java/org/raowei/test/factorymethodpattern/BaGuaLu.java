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
			System.out.println("必须指定人种颜色");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("人种定义错误");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("混蛋，你指定的人种不存在");
			e.printStackTrace();
		}
		return human;
	}
}
