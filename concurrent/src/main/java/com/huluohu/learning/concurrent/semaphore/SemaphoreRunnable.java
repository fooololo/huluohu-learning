package com.huluohu.learning.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   17:58
 * Description    :
 */
public class SemaphoreRunnable implements Runnable {
	Semaphore semaphore;

	public SemaphoreRunnable(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " running...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
}
