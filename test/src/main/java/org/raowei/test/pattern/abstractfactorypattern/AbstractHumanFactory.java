package org.raowei.test.pattern.abstractfactorypattern;

import org.raowei.test.enums.HumanEnum;

public abstract class AbstractHumanFactory implements HumanFactory{

	protected Human createHuman(HumanEnum humanEnum) {
		Human human = null;
		if (!humanEnum.getValue().equals("")) {
			try {
				human = (Human) Class.forName(humanEnum.getValue()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			
		}
		return human;
	}
	

}
