package com.huluohu.utils.log;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/12
 * Time           :   18:21
 * Description    :
 */
public class SystemLog {
	private static Logger logger = null;
	private static Semaphore semaphore = new Semaphore(1);
	public static Logger instance(){
		if(logger == null){
			try {
				semaphore.acquire();
				logger = Logger.getGlobal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}
		}
		return logger;
	}
	public static void info(String s){
		instance().info(s);
	}
}
