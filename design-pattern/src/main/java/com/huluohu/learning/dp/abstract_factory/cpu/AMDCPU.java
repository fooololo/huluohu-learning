package com.huluohu.learning.dp.abstract_factory.cpu;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:13
 * Description    :
 */
public class AMDCPU implements CPU{
	@Override public void process() {
		System.out.println("AMD processing...");
	}
}
