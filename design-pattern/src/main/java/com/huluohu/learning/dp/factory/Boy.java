package com.huluohu.learning.dp.factory;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   10:44
 * Description    :
 */
public class Boy implements Human{
	@Override public void talk() {
		System.out.println("Boy talking...");
	}

	@Override public void walk() {
		System.out.println("Boy walking...");
	}
}
