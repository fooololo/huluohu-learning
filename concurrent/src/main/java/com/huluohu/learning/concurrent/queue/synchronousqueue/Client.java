package com.huluohu.learning.concurrent.queue.synchronousqueue;

import com.huluohu.learning.concurrent.queue.Consumer;
import com.huluohu.learning.concurrent.queue.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   10:25
 * Description    :SynchronousQueue 是一个特殊的队列，它的内部同时只能够容纳单个元素。
 * 如果该队列已有一元素的话，试图向队列中插入一个新元素的线程将会阻塞，直到另一个线程将该元素从队列中抽走。
 * 同样，如果该队列为空，试图向队列中抽取一个元素的线程将会阻塞，直到另一个线程向队列中插入了一条新的元素。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue queue = new SynchronousQueue<>();

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
