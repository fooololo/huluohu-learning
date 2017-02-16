package com.huluohu.learning.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   14:38
 * Description    :
 */
public class Decrementer implements Runnable {
	CountDownLatch latch;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override public void run() {
		try {
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("-1");

			Thread.sleep(1000);
			latch.countDown();
			System.out.println("-2");

			Thread.sleep(1000);
			latch.countDown();
			System.out.println("-3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
