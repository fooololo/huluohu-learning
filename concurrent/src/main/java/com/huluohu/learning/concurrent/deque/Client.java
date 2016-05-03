package com.huluohu.learning.concurrent.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   10:53
 * Description    :BlockingDeque 类是一个双端队列，在不能够插入元素时，它将阻塞住试图插入元素的线程；
 * 在不能够抽取元素时，它将阻塞住试图抽取的线程。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque deque = new LinkedBlockingDeque<>();

		Producer producer = new Producer(deque);
		Consumer consumer = new Consumer(deque);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}
