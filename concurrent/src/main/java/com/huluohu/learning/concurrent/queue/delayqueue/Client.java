package com.huluohu.learning.concurrent.queue.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   9:41
 * Description    :DelayQueue 对元素进行持有直到一个特定的延迟到期。
 * DelayQueue 将会在每个元素的 getDelay() 方法返回的值的时间段之后才释放掉该元素。
 * 如果返回的是 0 或者负值，延迟将被认为过期，该元素将会在 DelayQueue 的下一次 take  被调用的时候被释放掉。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		DelayQueue queue = new DelayQueue();

		Delayed delayed = new DelayedElement();
		queue.put(delayed);

		Delayed ele = queue.take();
		System.out.println(ele);
	}
}
