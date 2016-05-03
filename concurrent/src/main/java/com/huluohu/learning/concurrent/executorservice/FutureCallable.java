package com.huluohu.learning.concurrent.executorservice;

import java.util.concurrent.Callable;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/12
 * Time           :   17:41
 * Description    :
 */
public class FutureCallable implements Callable {
	@Override public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " run Callable");
		Thread.sleep(3000);
		return true;
	}
}
