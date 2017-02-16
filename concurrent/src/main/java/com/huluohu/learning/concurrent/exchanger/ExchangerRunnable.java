package com.huluohu.learning.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   16:51
 * Description    :
 */
public class ExchangerRunnable implements Runnable {
	Exchanger exchanger;
	Object object;

	public ExchangerRunnable(Exchanger exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	@Override public void run() {
		try {
			Object prev = this.object;
			this.object = this.exchanger.exchange(this.object);
			System.out.println(Thread.currentThread().getName() + "exchanged " + prev + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
