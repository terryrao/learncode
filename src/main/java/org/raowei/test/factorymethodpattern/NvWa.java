package org.raowei.test.factorymethodpattern;

public class NvWa {
	public static void main(String[] args) {
		
		BaGuaLu baGuaLu = BaGuaLu.getInstance();
		System.out.println("----------------造出白人--------------");
		Human whitehHuman = baGuaLu.createHuman(WhiteMan.class);
		whitehHuman.cry();
		whitehHuman.laugh();
		whitehHuman.talk();
		
		System.out.println("----------------造出黑人--------------");
		Human blackHuman = baGuaLu.createHuman(BlackMan.class);
		blackHuman.cry();
		blackHuman.laugh();
		blackHuman.talk();
		
		System.out.println("----------------造出黄种人--------------");
		Human yellowHuman = baGuaLu.createHuman(YellowMan.class);
		yellowHuman.cry();
		yellowHuman.laugh();
		yellowHuman.talk();
		
	}
}
