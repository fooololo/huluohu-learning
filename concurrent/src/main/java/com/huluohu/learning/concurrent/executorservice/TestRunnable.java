package com.huluohu.learning.concurrent.executorservice;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   18:08
 * Description    :
 */
public class TestRunnable implements Runnable {
	@Override public void run() {
		System.out.println(Thread.currentThread().getName() + " running...");
	}
}
