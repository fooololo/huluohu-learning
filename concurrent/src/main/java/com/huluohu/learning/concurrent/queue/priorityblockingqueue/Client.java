package com.huluohu.learning.concurrent.queue.priorityblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   10:17
 * Description    :PriorityBlockingQueue 是一个无界的并发队列。它使用了和类 java.util.PriorityQueue 一样的排序规则。
 * 你无法向这个队列中插入 null 值。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue queue = new PriorityBlockingQueue<>();
		queue.put("val1");
		queue.put("val2");
		queue.put("val3");
		queue.put("val4");

		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
	}
}
