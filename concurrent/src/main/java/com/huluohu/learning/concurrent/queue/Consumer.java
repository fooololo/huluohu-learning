package com.huluohu.learning.concurrent.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   9:05
 * Description    :
 */
public class Consumer implements Runnable {
	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
