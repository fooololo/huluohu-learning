package com.huluohu.learning.dp.mediator.pojo;

import com.huluohu.learning.dp.mediator.AbstractMediator;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:23
 * Description    :		库存管理类
 */
public class Stock extends AbstractColleague{
	public Stock(AbstractMediator mediator) {
		super(mediator);
	}
	//IBM电脑的当前库存
	private static int IBM_COMPUTER_NUM = 100;

	//增加IBM电脑库存
	public void increase(int num){
		IBM_COMPUTER_NUM += num;
		System.out.println("IBM库存数量：" + IBM_COMPUTER_NUM);
	}
	//减少IBM电脑库存
	public void decrease(int num){
		System.out.println("IBM库存数量：" + IBM_COMPUTER_NUM);
		IBM_COMPUTER_NUM -= num;
	}
	//获取IBM电脑库存
	public int getIBMStockNum(){
		return IBM_COMPUTER_NUM;
	}
	//清空IBM电脑库存
	public void clearStock(){
		System.out.println("清空IBM电脑库存：" + IBM_COMPUTER_NUM);
		super.mediator.execute("stock.clear");
	}
}
