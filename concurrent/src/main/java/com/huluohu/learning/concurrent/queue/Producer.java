package com.huluohu.learning.concurrent.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   9:05
 * Description    :
 */
public class Producer implements Runnable {
	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override public void run() {
		try {
			queue.put("val1");
			Thread.sleep(1000);
			queue.put("val2");
			Thread.sleep(1000);
			queue.put("val3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
