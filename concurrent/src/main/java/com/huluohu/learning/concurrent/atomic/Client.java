package com.huluohu.learning.concurrent.atomic;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/29
 * Time           :   16:32
 * Description    :
 */
public class Client {
	public static void main(String[] args) throws ExecutionException, InterruptedException,
			UnsupportedEncodingException {
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
	}

	private static void test5() throws UnsupportedEncodingException {
		Base64.Encoder encoder = Base64.getEncoder();
		encoder = Base64.getUrlEncoder();
		String e = "guxiaolong";
		String ee = encoder.encodeToString(e.getBytes("utf-8"));
		System.out.println(ee);
		Base64.Decoder decoder = Base64.getDecoder();
		decoder = Base64.getUrlDecoder();
		byte[] dd = decoder.decode(ee);
		System.out.println(new String(dd,"utf-8"));
	}

	private static void test4() throws ExecutionException, InterruptedException {
		AtomicReference<String> reference = new AtomicReference<>("aaa");
		System.out.println(reference.get());
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		Future future = null;
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			final int n = random.nextInt(1000);
			String t = "第" + i + ":>>>" + n;
			future = executorService.submit(()->reference.set(t));
		}
		future.get();
		System.out.println(reference.get());
		System.out.println(reference.compareAndSet("ac","aaa"));
	}

	private static void test3() throws ExecutionException, InterruptedException {
		AtomicLong atomicLong = new AtomicLong();
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		Future future = null;
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			final int n = random.nextInt(1000);
			System.out.println("第" + i + ":>>>" + n);
			future = executorService.submit(()->atomicLong.set(n));
		}
		future.get();
		System.out.println(atomicLong.get());
		System.out.println(atomicLong.getAndIncrement());
		System.out.println(atomicLong.get());
		System.out.println(atomicLong.incrementAndGet());
		System.out.println(atomicLong.compareAndSet(100,0));
		executorService.shutdown();
	}

	private static void test2() throws ExecutionException, InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger();
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		Future future = null;
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			final int n = random.nextInt(1000);
			System.out.println("第" + i + ":>>>" + n);
			future = executorService.submit(()->atomicInteger.set(n));
		}
		future.get();
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.incrementAndGet());
		System.out.println(atomicInteger.compareAndSet(0,1001));
		executorService.shutdown();
	}

	private static void test1() {
		AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		System.out.println(atomicBoolean.get());
		System.out.println(atomicBoolean.getAndSet(false));
		System.out.println(atomicBoolean.get());
		System.out.println(atomicBoolean.compareAndSet(false,false));
		System.out.println(atomicBoolean.get());
	}
}
