package com.huluohu.learning.dp.singleton;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   16:54
 * Description    :
 */
public class AmericaPresident {
	private static final AmericaPresident americaPresident = new AmericaPresident();
	private AmericaPresident(){};
	public void say(){
		System.out.println("president say...");
	}

	public static AmericaPresident getAmericaPresident(){
		return americaPresident;
	}

}
