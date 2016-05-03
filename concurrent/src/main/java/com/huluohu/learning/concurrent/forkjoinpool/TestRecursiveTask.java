package com.huluohu.learning.concurrent.forkjoinpool;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/28
 * Time           :   18:57
 * Description    :
 */
public class TestRecursiveTask extends RecursiveTask<Integer> {
	private static final Logger logger = Logger.getGlobal();
	private Path path;

	public TestRecursiveTask(Path path) {
		this.path = path;
	}

	@Override protected Integer compute() {
		int count = 0;
		List<TestRecursiveTask> subActions = new ArrayList<>();
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
			for (Path path : ds) {
				if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)){
					subActions.add(new TestRecursiveTask(path));
				}else{
					logger.info("name:" + path.getParent() + "/" + path.getFileName() + ",lastModified:" + path.toFile().lastModified());
					count++;
				}
				if(!subActions.isEmpty()){
					// 在当前的 ForkJoinPool 合并结果。
					for (TestRecursiveTask task : invokeAll(subActions)) {
						count += task.join();
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
