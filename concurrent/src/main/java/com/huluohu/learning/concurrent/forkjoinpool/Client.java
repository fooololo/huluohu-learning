package com.huluohu.learning.concurrent.forkjoinpool;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/28
 * Time           :   14:50
 * Description    :
 */
public class Client {
	public static final Logger logger = Logger.getGlobal();
	public static void main(String[] args) {
//		test1();
		test2();
	}

	private static void test2() {
		ForkJoinPool pool = new ForkJoinPool();
		Path path = Paths.get("C:\\Users\\Administrator\\Pictures");
		TestRecursiveTask task = new TestRecursiveTask(path);
		Integer count = pool.invoke(task);
		logger.info("count->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + count);
	}



	private static void test1() {
		ForkJoinPool pool = new ForkJoinPool();
		Path path = Paths.get("C:\\Users\\Administrator\\Pictures");
		TestRecursiveAction action = new TestRecursiveAction(path);
		pool.invoke(action);
	}
}
