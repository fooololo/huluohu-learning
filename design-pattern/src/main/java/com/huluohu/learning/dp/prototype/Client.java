package com.huluohu.learning.dp.prototype;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   16:39
 * Description    :
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		SomePrototype somePrototype = new SomePrototype(1);
		for (int i = 1; i < 10; i++) {
			Prototype prototype = somePrototype.clone();
			prototype.setSize(i);
			prototype.printSize();
		}
	}
}
