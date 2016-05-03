package com.huluohu.learning.dp.template_method;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   14:31
 * Description    :
 */
public class Coffee extends CaffeineBeverage {
	@Override void addCondiments() {
		System.out.println("Adding Sugar and Milk...");
	}

	@Override void brew() {
		System.out.println("Dropping Coffee through filter...");
	}

	@Override boolean customerWantsCondiments() {
		return true;
	}
}
