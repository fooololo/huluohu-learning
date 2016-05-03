package com.huluohu.learning.dp.singleton;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   17:24
 * Description    :
 */
public class LockSingleton {
	private static LockSingleton intsance = null;
	private LockSingleton(){}
	public synchronized static LockSingleton getIntsance(){
		if(intsance == null){
			intsance = new LockSingleton();
		}
		return intsance;
	}
}
