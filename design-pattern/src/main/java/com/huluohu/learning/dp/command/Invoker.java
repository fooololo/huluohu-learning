package com.huluohu.learning.dp.command;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   18:06
 * Description    :命令请求者
 */
public class Invoker {
	/**
	 * 持有命令对象
	 */
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}
	//发送命令
	public void action(){
		command.execute();
	}
}
