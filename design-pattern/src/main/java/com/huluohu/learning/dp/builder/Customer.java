package com.huluohu.learning.dp.builder;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:59
 * Description    :
 */
public class Customer {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();

		//要一杯茶
		StarbucksBuilder teaBuilder = new TeaBuilder();
		waiter.setStarbucksBuilder(teaBuilder);
		waiter.constructStarbucks();
		Starbucks tea = waiter.getStarbucks();

		//要一杯咖啡
		StarbucksBuilder coffeeBuilder = new CoffeeBuilder();
		waiter.setStarbucksBuilder(coffeeBuilder);
		waiter.constructStarbucks();
		Starbucks coffee = waiter.getStarbucks();
	}
}
