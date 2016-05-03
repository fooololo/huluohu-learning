package com.huluohu.learning.dp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/13
 * Time           :   23:30
 * Description    :
 */
public class GamePlayerHander implements InvocationHandler {
	Class clazz;
	Object obj = null;

	public GamePlayerHander(Object obj) {
		this.obj = obj;
	}

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(this.obj,args);
		return result;
	}
}
