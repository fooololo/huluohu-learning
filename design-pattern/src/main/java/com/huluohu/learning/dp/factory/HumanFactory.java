package com.huluohu.learning.dp.factory;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   10:47
 * Description    :
 */
public class HumanFactory {
	public static <T extends Human> T createHuman(Class<T> clazz)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Human human = (Human) Class.forName(clazz.getName()).newInstance();
		return (T)human;
	}
}
