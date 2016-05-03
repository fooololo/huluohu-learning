package com.huluohu.learning.concurrent.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/28
 * Time           :   20:44
 * Description    :
 */
public  class ReentrantLocker {
	private Lock lock = new ReentrantLock();
	double	value = 0d;
	int	addTimes = 0;
	private void addValue(double v){
		lock.lock();
		System.out.println("ReentrantLocker to addValue:" + v
				+ "     " + Thread.currentThread().getName()
				+ "     " + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			value += v;
			addTimes++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public static void test() throws ExecutionException, InterruptedException {
		final ReentrantLocker locker = new ReentrantLocker();
		ExecutorService cacheService = Executors.newFixedThreadPool(3);
		Future future = null;
		for (int i = 0; i < 15; i++) {
			future = cacheService.submit(() -> locker.addValue(44.56));
		}
		future.get();

		future = cacheService.submit(()-> {
			System.out.println("value=" + locker.getValue());
			System.out.println("times=" + locker.getAddTimes());
		});
		future.get();
		cacheService.shutdown();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getAddTimes() {
		return addTimes;
	}

	public void setAddTimes(int addTimes) {
		this.addTimes = addTimes;
	}
}
