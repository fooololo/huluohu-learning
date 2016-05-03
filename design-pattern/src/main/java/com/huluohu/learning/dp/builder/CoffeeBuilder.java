package com.huluohu.learning.dp.builder;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:55
 * Description    :
 */
public class CoffeeBuilder extends StarbucksBuilder {
	@Override public void buildSize() {
		starbucks.setSize("medium");
		System.out.println("build medium size");
	}

	@Override public void buildDrink() {
		starbucks.setDrink("coffee");
		System.out.println("build coffee");
	}
}
