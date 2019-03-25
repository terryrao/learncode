package org.raowei.test.pattern.proxypattern;

public class WangPo implements KindWomen{
	private KindWomen panjinlian;
	public WangPo(){
		this.panjinlian = new PanJinLian();
	}
	public void makeEyeWithMan() {
		this.panjinlian.makeEyeWithMan();
	}

	public void happyWithMan() {
		this.panjinlian.happyWithMan();
	}

}
