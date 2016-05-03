package com.huluohu.learning.dp.observer;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/15
 * Time           :   9:20
 * Description    :   发布者
 */
public interface Subject {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyAllObservers();
}
