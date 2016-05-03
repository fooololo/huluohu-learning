package com.huluohu.learning.dp.proxy;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/12
 * Time           :   18:42
 * Description    :
 */
public class Proxy implements Subject {
	private Subject	subject = null;

	public Proxy() {
		this.subject = new Proxy();
	}

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override public void request() {
		this.before();
		this.subject.request();
		this.after();
	}

	private void after() {
		System.out.println("后处理");
	}

	private void before() {
		System.out.println("前处理");
	}
}
