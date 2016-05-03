package com.huluohu.learning.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   14:50
 * Description    :是一种同步机制，它能够对处理一些算法的线程实现同步。
 * 换句话讲，它就是一个所有线程必须等待的一个栅栏，直到所有线程都到达这里，
 * 然后所有线程才可以继续做其他事情。
 */
public class Client {
	public static void main(String[] args) {
		Runnable action1 = new Runnable() {
			@Override public void run() {
				System.out.println("action 1");
			}
		};

		Runnable action2 = new Runnable() {
			@Override public void run() {
				System.out.println("action 2");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2,action1);
		CyclicBarrier barrier2 = new CyclicBarrier(2,action2);


		CyclicBarrierRunnable runnable1 = new CyclicBarrierRunnable(barrier1,barrier2);
		CyclicBarrierRunnable runnable2 = new CyclicBarrierRunnable(barrier1,barrier2);

		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}
}
