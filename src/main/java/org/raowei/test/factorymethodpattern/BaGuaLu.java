package org.raowei.test.factorymethodpattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.raowei.test.util.ClassUtils;



public class BaGuaLu {
	private static BaGuaLu baGuaLu = new BaGuaLu();
	private static Map<String, Human> humans = new HashMap<String, Human> ();
	private BaGuaLu() {

	}

	public static BaGuaLu getInstance() {
		return baGuaLu;
	}

	public Human createHuman(Class<?> c) {
		Human human = null;
		try {
			if (humans.containsKey(c.getName())) {
				human = humans.get(c.getName());
			}else {
				human = (Human) Class.forName(c.getName()).newInstance();
				humans.put(c.getName(), human);
				
			}
			
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

	public Human createHuman() {
		Human human = null;
		List<Class<?>> list = ClassUtils.getAllClassesByInterface(Human.class);
		Random random = new Random();
		int rand = random.nextInt(list.size());
		human = this.createHuman(list.get(rand));
		return human;
	}
}
