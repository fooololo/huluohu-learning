package com.huluohu.learning.dp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/13
 * Time           :   23:32
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("张三");
		InvocationHandler handler = new GamePlayerHander(player);

		ClassLoader loader = player.getClass().getClassLoader();

		IGamePlayer proxy =
				(IGamePlayer) Proxy.newProxyInstance(loader,new Class[]{IGamePlayer.class},handler);
		proxy.login("zhangsan","123456");
		proxy.killBoss();
		proxy.upgrade();;
	}
}
