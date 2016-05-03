package com.huluohu.learning.dp.builder;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   11:50
 * Description    :
 */
public abstract class StarbucksBuilder {
	protected Starbucks starbucks;
	public void createStarBucks(){
		starbucks = new Starbucks();
		System.out.println("a drink created");
	}

	public abstract void buildSize();
	public abstract void buildDrink();

	public Starbucks getStarbucks() {
		return starbucks;
	}
}
