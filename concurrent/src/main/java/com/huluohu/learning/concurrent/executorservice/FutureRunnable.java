package com.huluohu.learning.concurrent.executorservice;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/8
 * Time           :   11:50
 * Description    :
 */
public class FutureRunnable implements Runnable {
	@Override public void run() {
		System.out.println("FutureRunnable...");
	}
}
