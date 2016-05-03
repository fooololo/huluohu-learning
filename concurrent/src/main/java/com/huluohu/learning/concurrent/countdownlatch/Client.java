package com.huluohu.learning.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   14:34
 * Description    :CountDownLatch 以一个给定的数量初始化。countDown() 每被调用一次，
 * 这一数量就减一。通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(2000);
	}
}
