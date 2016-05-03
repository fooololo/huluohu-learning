package com.huluohu.learning.dp.abstract_factory.cpu;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:14
 * Description    :
 */
public class IntelCPU implements CPU{
	@Override public void process() {
		System.out.println("intel processing...");
	}
}
