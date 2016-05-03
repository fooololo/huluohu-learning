package com.huluohu.learning.dp.singleton;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   17:16
 * Description    :
 */
public class OptSingleton {
	private static OptSingleton instance = null;
	private OptSingleton(){}
	public static OptSingleton getInstance(){
		//用到的时候才创建对象
		if(instance == null){
			instance = new OptSingleton();
		}
		return instance;
	}
}
