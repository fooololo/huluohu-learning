package com.huluohu.learning.concurrent.queue.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   9:37
 * Description    :
 */
public class DelayedElement implements Delayed {
	@Override public long getDelay(TimeUnit unit) {
		return unit.toSeconds(5);
	}

	@Override public int compareTo(Delayed o) {
		return this.compareTo(o);
	}
}
