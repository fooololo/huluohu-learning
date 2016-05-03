package com.huluohu.learning.dp.abstract_factory.cpu;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:15
 * Description    :
 */
public class Computer {
	CPU cpu;

	public Computer(CPUFactory factory) {
		this.cpu = factory.produceCPU();
		cpu.process();
	}
}
