package com.huluohu.learning.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   15:08
 * Description    :
 */
public class CyclicBarrierRunnable implements Runnable {
	CyclicBarrier cyclicBarrier1;
	CyclicBarrier cyclicBarrier2;

	public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2) {
		this.cyclicBarrier1 = cyclicBarrier1;
		this.cyclicBarrier2 = cyclicBarrier2;
	}

	@Override public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()	 + "waiting at barrier1");
			cyclicBarrier1.await();

			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()	 + "waiting at barrier2");
			cyclicBarrier2.await();

			System.out.println(Thread.currentThread().getName()	 + "done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
