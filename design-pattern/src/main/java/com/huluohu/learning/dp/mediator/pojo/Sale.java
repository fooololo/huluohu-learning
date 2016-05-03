package com.huluohu.learning.dp.mediator.pojo;

import com.huluohu.learning.dp.mediator.AbstractMediator;

import java.util.Random;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:25
 * Description    :		销售管理类
 */
public class Sale extends AbstractColleague{
	public Sale(AbstractMediator mediator) {
		super(mediator);
	}

	//销售IBM电脑
	public void sellIBMComputer(int num){
		super.mediator.execute("sale.sell",num);
		System.out.println("销售IBM电脑：" + num );
	}
	//获取销售状态（随机数）
	public int getSaleStatus(){
		Random random = new Random(System.currentTimeMillis());
		int saleStatus = random.nextInt(100);
		System.out.println("IBM电脑销售状态为：" + saleStatus);
		return saleStatus;
	}
	//5折销售
	public void offSale(){
		super.mediator.execute("sale.offsale");
	}

}
