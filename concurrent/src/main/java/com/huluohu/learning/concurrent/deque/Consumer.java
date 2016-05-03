package com.huluohu.learning.concurrent.deque;

import java.util.concurrent.BlockingDeque;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   10:52
 * Description    :
 */
public class Consumer implements Runnable {
	protected BlockingDeque deque;

	public Consumer(BlockingDeque deque) {
		this.deque = deque;
	}

	@Override public void run() {
		try {
			System.out.println(deque.takeFirst());
			System.out.println(deque.takeFirst());
			System.out.println(deque.takeFirst());

			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
			System.out.println(deque.takeLast());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
