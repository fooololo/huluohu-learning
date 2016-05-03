package com.huluohu.learning.dp.factory;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   10:45
 * Description    :
 */
public class Girl implements Human{
	@Override public void talk() {
		System.out.println("Girl talking...");
	}

	@Override public void walk() {
		System.out.println("Girl walking...");
	}
}
