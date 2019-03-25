package org.raowei.test.pattern.abstractfactorypattern;

import org.raowei.test.enums.HumanEnum;

public class MaleHumanFactory extends AbstractHumanFactory{
	
	//单例
	private static HumanFactory humanFactory = new MaleHumanFactory();
	
	private MaleHumanFactory () {
		
	}

	public  static HumanFactory getInstance() {
		return humanFactory;
	}
	public Human createYellowHuman() {

		return super.createHuman(HumanEnum.YellowMaleHuman);
	}

	public Human createWhitehHuman() {
		return super.createHuman(HumanEnum.WhiteManHuman);
	}

	public Human creatBlackHuman() {
		return super.createHuman(HumanEnum.BlackMaleHuman);
	}

}
