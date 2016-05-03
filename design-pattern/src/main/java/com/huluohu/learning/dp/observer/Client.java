package com.huluohu.learning.dp.observer;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/15
 * Time           :   9:33
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		HeadHunter headHunter = new HeadHunter();
		headHunter.registerObserver(new JobSeeker("小明"));
		headHunter.registerObserver(new JobSeeker("大名"));
		headHunter.registerObserver(new JobSeeker("明明"));

		headHunter.addJob("程序猿");
		headHunter.addJob("程序猿鼓励师");
	}
}
