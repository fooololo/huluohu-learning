package com.huluohu.learning.concurrent.lock;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/29
 * Time           :   16:10
 * Description    :
 */
public class ReentrantReadWriteLocker {
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	double	value = 0d;
	int	addTimes = 0;

	private void addValue(double v){
		Lock writeLock = this.lock.writeLock();
		writeLock.lock();
		System.out.println("ReentrantReadWriteLocker to addValue:" + v
				+ "     " + Thread.currentThread().getName()
				+ "     " + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			value += v;
			addTimes++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			writeLock.unlock();
		}
	}

	private String getInfo(){
		Lock readLock = this.lock.readLock();
		readLock.lock();
		System.out.println("ReentrantReadWriteLocker to getInfo:"
				+ "     " + Thread.currentThread().getName()
				+ "     " + System.currentTimeMillis());
		try {
			Thread.sleep(2000);
			return "value=" + value + ",times=" + addTimes;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			readLock.unlock();
		}
		return null;
	}

	public static void test() throws ExecutionException, InterruptedException {
		final ReentrantReadWriteLocker locker = new ReentrantReadWriteLocker();
		ExecutorService cacheService = Executors.newFixedThreadPool(3);
		Future future = null;
		Random random = new Random(1);
		for (int i = 0; i < 20; i++) {
			int r = random.nextInt();
			if(r < 1){
				future = cacheService.submit(()->locker.addValue(12.33));
			}else {
				future = cacheService.submit(()-> System.out.println(locker.getInfo()));
			}
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
