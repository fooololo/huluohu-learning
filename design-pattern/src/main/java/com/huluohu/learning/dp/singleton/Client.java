package com.huluohu.learning.dp.singleton;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   17:07
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		AmericaPresident president1 = AmericaPresident.getAmericaPresident();
		AmericaPresident president2 = AmericaPresident.getAmericaPresident();
		System.out.println(president1 == president2);
	}
}
