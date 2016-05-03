package com.huluohu.learning.dp.factory;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   10:58
 * Description    :
 */
public class Client {
	public static void main(String[] args)
			throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		Human boy = HumanFactory.createHuman(Boy.class);
		Human girl = HumanFactory.createHuman(Girl.class);

		boy.talk();
		boy.walk();

		girl.talk();
		girl.walk();
	}
}
