package com.huluohu.learning.dp.builder;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:53
 * Description    :
 */
public class TeaBuilder extends StarbucksBuilder {
	@Override public void buildSize() {
		starbucks.setSize("large");
		System.out.println("build large size");
	}

	@Override public void buildDrink() {
		starbucks.setDrink("tea");
		System.out.println("build tea");
	}
}
