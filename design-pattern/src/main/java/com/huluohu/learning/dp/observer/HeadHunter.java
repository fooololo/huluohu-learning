package com.huluohu.learning.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/15
 * Time           :   9:23
 * Description    :   猎头
 */
public class HeadHunter implements Subject{
	private List<Observer> observers;
	private List<String> jobs;

	public HeadHunter() {
		observers = new ArrayList<Observer>();
		jobs = new ArrayList<String>();
	}

	@Override public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override public void notifyAllObservers() {
		for (Observer observer:observers) {
			observer.update(this);
		}
	}

	public void addJob(String job){
		jobs.add(job);
		notifyAllObservers();
	}

	public List<String> getJobs(){
		return jobs;
	}

	@Override public String toString() {
		return jobs.toString();
	}
}
