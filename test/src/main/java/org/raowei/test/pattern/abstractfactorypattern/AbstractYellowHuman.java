package org.raowei.test.pattern.abstractfactorypattern;

public abstract class AbstractYellowHuman implements Human{
	public void cry() {
		System.out.println("黄种人会哭");
	}
	
	public void laught () {
		System.out.println("黄种人会笑");
	}
	
	public void talk() {
		System.out.println("黄种人会交谈");
	}
	
}
