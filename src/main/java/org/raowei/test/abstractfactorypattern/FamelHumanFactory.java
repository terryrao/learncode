package org.raowei.test.abstractfactorypattern;

import org.raowei.test.enums.HumanEnum;

public class FamelHumanFactory extends AbstractHumanFactory {

	private static HumanFactory humanFactory = new FamelHumanFactory();

	private FamelHumanFactory() {

	}

	public static HumanFactory getInstance() {
		return humanFactory;
	}

	public Human createYellowHuman() {
		return super.createHuman(HumanEnum.YellowFamelHuman);
	}

	public Human createWhitehHuman() {
		return super.createHuman(HumanEnum.WhiteFamelHuman);
	}

	public Human creatBlackHuman() {
		return super.createHuman(HumanEnum.BlackFamelHuman);
	}

}
