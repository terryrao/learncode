package org.raowei.test.abstractfactorypattern;

public abstract class AbstractBlackHuman implements Human{

	public void laught() {
		System.out.println("黑人会哭");
	}

	public void cry() {
		System.out.println("黑人会笑");
		
	}

	public void talk() {
		System.out.println("黑人会说话");
	}


}
