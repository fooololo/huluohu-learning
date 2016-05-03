package com.huluohu.learning.dp.mediator;

import com.uml.clazz.demo.mediator.pojo.Purchase;
import com.uml.clazz.demo.mediator.pojo.Sale;
import com.uml.clazz.demo.mediator.pojo.Stock;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/15
 * Time           :   10:27
 * Description    :		中介者
 */
public class Mediator extends AbstractMediator{
	public Mediator() {
		super();
	}

	@Override public void execute(String str, Object... obj) {
		//采购
		if("purchase.buy".equals(str)){
			this.buyIBMComputer(Integer.valueOf(String.valueOf(obj[0])));
		}
		//销售
		else if("sale.sell".equals(str)){
			this.sellIBMComputer(Integer.valueOf(String.valueOf(obj[0])));
		}
		//折价销售
		else if("sale.offsell".equals(str)){
			this.offsellIBMComputer();
		}
		//清仓
		else if("stock.clear".equals(str)){
			this.clearStock();
		}
	}

	private void clearStock() {
		super.sale.offSale();
		super.purchase.refuseByIBMComputer();
	}

	private void offsellIBMComputer() {
		System.out.println("折价销售IBM电脑："+ stock.getIBMStockNum());
	}

	private void sellIBMComputer(Integer num) {
		if(super.stock.getIBMStockNum() < num){
			super.purchase.buyIBMComputer(num);
		}
		super.stock.decrease(num);
	}

	private void buyIBMComputer(Integer num) {
		int saleStatus = this.sale.getSaleStatus();
		//销量好
		if(saleStatus > 80){
			System.out.println("采购IBM电脑：" + num);
			super.stock.increase(num);
		}
		//销量不好，折半采购
		else{
			num /= 2;
			System.out.println("采购IBM电脑：" + num);
			super.stock.increase(num);
		}
	}
}
