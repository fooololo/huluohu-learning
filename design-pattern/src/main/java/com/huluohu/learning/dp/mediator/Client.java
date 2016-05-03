package com.huluohu.learning.dp.mediator;

import com.huluohu.learning.dp.mediator.pojo.Purchase;
import com.huluohu.learning.dp.mediator.pojo.Sale;
import com.huluohu.learning.dp.mediator.pojo.Stock;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   14:12
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		AbstractMediator mediator = new Mediator();
		System.out.println("------------采购电脑-----------");
		Purchase purchase = new Purchase(mediator);
		purchase.buyIBMComputer(102);

		System.out.println("-------------销售电脑-----------");
		Sale sale = new Sale(mediator);
		sale.sellIBMComputer(20);

		System.out.println("-------------清理库存-----------");
		Stock stock = new Stock(mediator);
		stock.clearStock();
	}
}
