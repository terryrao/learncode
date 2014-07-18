package org.raowei.test.multitionpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Emperor {
	private static int maxNumEmperor = 2;
	private static List<String> emperorInfo = new ArrayList<String>(maxNumEmperor);
	private static List<Emperor> emperors = new ArrayList<Emperor>(maxNumEmperor);
	private static int countNumOfEmperor = 0;
	
	static {
		for(int i = 0 ; i < maxNumEmperor; i++) {
			emperors.add(new Emperor("皇帝" + i));
		}
	}
	
	private Emperor() {
		
	}
	private Emperor(String info) {
		emperorInfo.add(info);
	}
	
	public static Emperor getInstance(){
		Random random = new Random();
		countNumOfEmperor = random.nextInt(maxNumEmperor);
		return emperors.get(countNumOfEmperor);
	}
	
	public  void getInfo() {
		System.out.println(emperorInfo.get(countNumOfEmperor));
	}
	
}
