package com.huluohu.learning.dp.observer;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/15
 * Time           :   9:31
 * Description    :
 */
public class JobSeeker implements Observer {
	private String name;

	public JobSeeker(String name) {
		this.name = name;
	}

	@Override public void update(Subject subject) {
		System.out.println(this.name + " got notified!");
		System.out.println("Subject is " + subject);
	}
}
