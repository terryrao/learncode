package org.raowei.test.enums;

import org.raowei.test.pattern.abstractfactorypattern.BlackManHuman;
import org.raowei.test.pattern.abstractfactorypattern.YellowFamelHuman;
import org.raowei.test.pattern.abstractfactorypattern.YellowManHuman;

public enum HumanEnum {
	YellowMaleHuman(YellowManHuman.class.getName()), YellowFamelHuman(YellowFamelHuman.class.getName()), BlackMaleHuman(
			BlackManHuman.class.getName()), BlackFamelHuman("org.raowei.test.pattern.abstractfactorypattern.BlackFamelHuman"), WhiteFamelHuman(
			BlackManHuman.class.getName()), WhiteManHuman("org.raowei.test.pattern.abstractfactorypattern.WhiteManHuman");

	private String value;

	private HumanEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
