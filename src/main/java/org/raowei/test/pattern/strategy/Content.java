package org.raowei.test.pattern.strategy;

public class Content {
	private IStrategy strategy;
	public Content (IStrategy strategy) {
		this.strategy = strategy;
	}
	public void operator() {
		this.strategy.operate();
	}
}
