package com.huluohu.htest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huluohu.utils.http.HttpClientUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/13
 * Time           :   15:58
 * Description    :
 */
public class Test1 {
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	@Test
	public void testSend() throws ExecutionException, InterruptedException {
		final String url = "http://ume3.umetrip.com/razor-master/cobub/index.php?/ums/postClientData";
		final Map<String,String> args = Maps.newHashMap();
		args.put("content","{\"deviceid\":\"12dee86ad67b1b0b9ac4628f779568c7\",\"os_version\":\"5.1\",\"platform\":\"android\",\"language\":\"zh\",\"appkey\":\"29e8c090006a4db03fd297a611b4d73b\"}");

		List<Future<String>> futures = Lists.newArrayList();
		for (int i = 0; i < 100000; i++) {
			Future<String> future = executorService.submit(() -> {
				String post = HttpClientUtils.post(url, args);
				return post;
			});
			futures.add(future);
		}
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		executorService.shutdown();
	}
}
