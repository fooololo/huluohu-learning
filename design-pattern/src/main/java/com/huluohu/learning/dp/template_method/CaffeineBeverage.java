package com.huluohu.learning.dp.template_method;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   14:24
 * Description    :
 */
public abstract class CaffeineBeverage {
	final void prepareRecipe(){
		//烧水
		boilWater();
		//用热水泡茶或咖啡
		brew();
		//倒进杯子
		pourInCup();

		//加入调料
		//钩子:是否加调料
		if(customerWantsCondiments()){
			addCondiments();
		}
	}

	abstract void addCondiments();

	private void pourInCup() {
		System.out.println("Pouring into cup...");
	}

	abstract void brew();

	protected  void boilWater(){
		System.out.println("Boiling water...");
	};
	boolean customerWantsCondiments(){
		return true;
	}
}
