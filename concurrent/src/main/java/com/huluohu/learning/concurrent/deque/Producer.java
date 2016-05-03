package com.huluohu.learning.concurrent.deque;

import java.util.concurrent.BlockingDeque;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   10:50
 * Description    :
 */
public class Producer implements Runnable {
	protected BlockingDeque deque;

	public Producer(BlockingDeque deque) {
		this.deque = deque;
	}

	@Override public void run() {
		try {
			deque.putFirst("f1");
			deque.putFirst("f2");
			deque.putFirst("f3");

			deque.putLast("l1");
			deque.putLast("l2");
			deque.putLast("l3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
