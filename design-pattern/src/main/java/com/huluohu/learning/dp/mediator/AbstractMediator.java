package com.huluohu.learning.dp.mediator;

import com.uml.clazz.demo.mediator.pojo.Purchase;
import com.uml.clazz.demo.mediator.pojo.Sale;
import com.uml.clazz.demo.mediator.pojo.Stock;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:21
 * Description    :
 */
public abstract class AbstractMediator {
	protected Purchase purchase;
	protected Stock stock;
	protected Sale sale;

	public AbstractMediator() {
		this.purchase = new Purchase(this);
		this.stock = new Stock(this);
		this.sale = new Sale(this);
	}

	/**
	 * 事件方法，处理多个对象之间的关系
	 * @param str
	 * @param obj
	 */
	public  abstract void execute(String str,Object... obj);
}
