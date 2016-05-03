package com.huluohu.learning.dp.abstract_factory.cpu;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:14
 * Description    :
 */
public class IntelFactory implements CPUFactory {
	@Override public CPU produceCPU() {
		return new IntelCPU();
	}
}
