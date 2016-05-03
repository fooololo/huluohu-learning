package com.huluohu.learning.dp.abstract_factory.cpu;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:16
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		Computer computer1 = new Computer(new AMDFactory());

		Computer computer2 = new Computer(new IntelFactory());
	}
}
