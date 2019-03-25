package org.raowei.test.pattern.abstractfactorypattern;

public class NvWa {
	public static void main(String[] args) {
		//第一条生产线  男性生产性
		HumanFactory maleFactory = MaleHumanFactory.getInstance();
		
		//第二条生产线 女性生产线
		HumanFactory famaleFactory = FamelHumanFactory.getInstance();
		
		//开始生产
		Human male = maleFactory.createWhitehHuman();
		male.cry();
		male.gender();
		male.laught();
		male.talk();
		
		Human femal = famaleFactory.createYellowHuman();
		femal.cry();
		femal.gender();
		femal.laught();
		femal.talk();
		
		
	}
}
