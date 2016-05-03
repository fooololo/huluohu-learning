package com.huluohu.learning.dp.proxy.dynamic;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/13
 * Time           :   23:29
 * Description    :
 */
public class GamePlayer implements IGamePlayer {
	private String name;

	public GamePlayer(String name) {
		this.name = name;
	}

	@Override public void login(String user, String pwd) {
		System.out.println("登录游戏...");
	}

	@Override public void killBoss() {
		System.out.println("杀死BOSS...");
	}

	@Override public void upgrade() {
		System.out.println("升级啦...");
	}
}
