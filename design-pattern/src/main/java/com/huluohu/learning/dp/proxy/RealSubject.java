package com.huluohu.learning.dp.proxy;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/12
 * Time           :   18:41
 * Description    :
 */
public class RealSubject implements Subject {
	@Override public void request() {
		System.out.println("真实的业务处理请求...");
	}
}
