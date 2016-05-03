package com.huluohu.learning.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   16:53
 * Description    :表示一种两个线程可以进行互相交换对象的会和点，交换对象的动作由 Exchanger 的两个 exchange() 方法的其中一个完成。
 */
public class Client {
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();
		ExchangerRunnable runnable1 = new ExchangerRunnable(exchanger,"A");
		ExchangerRunnable runnable2 = new ExchangerRunnable(exchanger,"B");

		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}
}
