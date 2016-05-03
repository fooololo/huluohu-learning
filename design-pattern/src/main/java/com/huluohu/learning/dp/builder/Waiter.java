package com.huluohu.learning.dp.builder;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:56
 * Description    :
 */
public class Waiter {
	private StarbucksBuilder starbucksBuilder;

	//制造饮料
	public void constructStarbucks(){
		starbucksBuilder.createStarBucks();
		starbucksBuilder.buildDrink();
		starbucksBuilder.buildSize();
	}

	public void setStarbucksBuilder(StarbucksBuilder starbucksBuilder) {
		this.starbucksBuilder = starbucksBuilder;
	}

	public Starbucks getStarbucks(){
		return starbucksBuilder.getStarbucks();
	}
}
