package com.huluohu.learning.concurrent.queue.arrayblockingqueue;

import com.huluohu.learning.concurrent.queue.Consumer;
import com.huluohu.learning.concurrent.queue.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   9:08
 * Description    :ArrayBlockingQueue 是一个有界的阻塞队列，其内部实现是将对象放到一个数组里。
 * 有界也就意味着，它不能够存储无限多数量的元素。它有一个同一时间能够存储元素数量的上限。
 * 你可以在对其初始化的时候设定这个上限，但之后就无法对这个上限进行修改了。
 * ArrayBlockingQueue 内部以 FIFO(先进先出)的顺序对元素进行存储。队
 * 列中的头元素在所有元素之中是放入时间最久的那个，而尾元素则是最短的那个。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}
