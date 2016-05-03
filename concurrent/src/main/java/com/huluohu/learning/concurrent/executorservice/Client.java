package com.huluohu.learning.concurrent.executorservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   18:08
 * Description    :
 */
public class Client {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		singleThreadExecutor();
//		fixedThreadPool();
//		scheduledThreadPool();

//		threadPoolExecutor();
		scheduledThreadPoolExecutor();
	}

	private static void scheduledThreadPoolExecutor() throws ExecutionException, InterruptedException {
		ScheduledExecutorService  service = new ScheduledThreadPoolExecutor(5);
		Future<String> submit = service.submit(() -> "test scheduledThreadPoolExecutor01");
		System.out.println(submit.get());

		ScheduledFuture<String> schedule = service.schedule(() -> "test scheduledThreadPoolExecutor01",
				2000, TimeUnit.MILLISECONDS);
		System.out.println(schedule.get());

		ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(() -> System.out.println(System.nanoTime()),
				2, 5, TimeUnit.SECONDS);

//		System.out.println(scheduledFuture.get());

//		service.shutdown();
	}

	private static void threadPoolExecutor() throws InterruptedException {
		ExecutorService service = new ThreadPoolExecutor(5,10,5000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
		Set<Callable<String>> callables = new HashSet<>();
		callables.add(()->{return "Callable01";});
		callables.add(()->{return "Callable02";});
		callables.add(()->{return "Callable03";});
		callables.add(()->{return "Callable04";});
		List<Future<String>> futures = service.invokeAll(callables);
		futures.forEach(s -> {
			try {
				System.out.println(s.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		service.shutdown();
	}

	private static void scheduledThreadPool() {
		ExecutorService executor = Executors.newScheduledThreadPool(2);
		executor.execute(new TestRunnable());
		executor.execute(new TestRunnable());
		executor.shutdown();
	}

	private static void fixedThreadPool() throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new TestRunnable());
		executor.execute(new TestRunnable());

		Future<?> f1 = executor.submit(new FutureRunnable());
		//returns null if the task has finished correctly.
		System.out.println(f1.get());

		Future f2 = executor.submit(new FutureCallable());
		System.out.println(f2.get());

		Set<Callable<String>> callables = new HashSet<>();
		callables.add(()->{return "Callable01";});
		callables.add(()->{return "Callable02";});
		callables.add(()->{return "Callable03";});
		callables.add(()->{return "Callable04";});

		String s = executor.invokeAny(callables);
		System.out.println("s->" + s);

		List<Future<String>> futures = executor.invokeAll(callables);
		for (Future f : futures) {
			System.out.println("f->" + f.get());
		}

		executor.shutdown();
	}

	private static void singleThreadExecutor() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new TestRunnable());
		executor.execute(new TestRunnable());
		executor.shutdown();
	}
}
