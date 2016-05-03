package com.huluohu.learning.concurrent.forkjoinpool;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/28
 * Time           :   14:54
 * Description    :
 */
public class TestRecursiveAction extends RecursiveAction{
	private static final Logger logger = Logger.getGlobal();
	private Path path;

	public TestRecursiveAction(Path path) {
		this.path = path;
	}

	@Override protected void compute() {
//		AtomicInteger count = new AtomicInteger(0);
		int count = 0;
		List<TestRecursiveAction> subActions = new ArrayList<>();
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
			for (Path path : ds) {
				if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)){
					subActions.add(new TestRecursiveAction(path));
				}else{
					logger.info("name:" + path.getParent() + "/" + path.getFileName() + ",lastModified:" + path.toFile().lastModified());
				}
				if(!subActions.isEmpty()){
					// 在当前的 ForkJoinPool 上调度所有的子任务。
					for (TestRecursiveAction action : subActions) {
						action.fork();
					}
				}
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
