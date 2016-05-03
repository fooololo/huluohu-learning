package com.huluohu.learning.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   14:36
 * Description    :
 */
public class Waiter implements Runnable {
	CountDownLatch latch;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override public void run() {
		try {
			latch.await();
			System.out.println("Waiter Released");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
