package com.huluohu.learning.dp.singleton;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   17:19
 * Description    :
 */
public class SafetySingleton {
	private SafetySingleton(){}
	private static class SingeltonClassInstance{
		private static final SafetySingleton instance = new SafetySingleton();
	}

	public static SafetySingleton getInstance(){
		return SingeltonClassInstance.instance;
	}
}
