package com.huluohu.learning.dp.mediator.pojo;

import com.huluohu.learning.dp.mediator.AbstractMediator;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:29
 * Description    :
 */
public abstract class AbstractColleague {
	protected AbstractMediator mediator;

	public AbstractColleague(AbstractMediator mediator) {
		this.mediator = mediator;
	}
}
