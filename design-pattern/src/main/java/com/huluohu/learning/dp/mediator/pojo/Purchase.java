package com.huluohu.learning.dp.mediator.pojo;

import com.uml.clazz.demo.mediator.AbstractMediator;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:23
 * Description    :		采购管理类
 */
public class Purchase extends AbstractColleague{

	public Purchase(AbstractMediator mediator) {
		super(mediator);
	}
	//采购IBM电脑
	public void buyIBMComputer(int num){
		super.mediator.execute("purchase.buy",num);
	}
	//拒绝采购
	public void refuseByIBMComputer(){
		System.out.println("不再采购IBM电脑");
	}

}
