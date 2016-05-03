package com.huluohu.learning.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   17:56
 * Description    :计数信号量由一个指定数量的 "许可" 初始化。每调用一次 acquire()，
 * 一个许可会被调用线程取走。每调用一次 release()，一个许可会被返还给信号量。
 * 因此，在没有任何 release() 调用时，最多有 N 个线程能够通过 acquire() 方法，N 是该信号量初始化时的许可的指定数量。
 */
public class Client {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		SemaphoreRunnable sr1 = new SemaphoreRunnable(semaphore);
		SemaphoreRunnable sr2 = new SemaphoreRunnable(semaphore);
		SemaphoreRunnable sr3 = new SemaphoreRunnable(semaphore);

		new Thread(sr1).start();
		new Thread(sr2).start();
		new Thread(sr3).start();

	}
}
