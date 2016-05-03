package com.huluohu.learning.concurrent.lock;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/28
 * Time           :   20:39
 * Description    :
 */
public class Client {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		test1();
//		test2();
		test3();
	}

	private static void test3() throws ExecutionException, InterruptedException {
		ReentrantReadWriteLocker.test();
	}

	private static void test2() {
		NumberFormat format = NumberFormat.getNumberInstance(Locale.CHINA);
		format = NumberFormat.getPercentInstance(Locale.CHINA);
		format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String value = format.format(100000090);
		System.out.println("金额:" + value);

		AtomicInteger atomicInteger = new AtomicInteger(0);
		atomicInteger.compareAndSet(1,2);
	}

	private static void test1() throws ExecutionException, InterruptedException {
		ReentrantLocker.test();
	}
}
