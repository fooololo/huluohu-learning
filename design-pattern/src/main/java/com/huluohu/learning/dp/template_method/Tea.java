package com.huluohu.learning.dp.template_method;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   14:29
 * Description    :
 */
public class Tea extends CaffeineBeverage {
	@Override void addCondiments() {
		System.out.println("Adding Lemon...");
	}

	@Override void brew() {
		System.out.println("Steeping the tea...");
	}

	@Override boolean customerWantsCondiments() {
		return false;
	}
}
