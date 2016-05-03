package com.huluohu.learning.dp.command;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   18:02
 * Description    :
 */
public class ConcreteCommand implements Command {
	private Receiver receiver = null;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override public void execute() {
		//通常会转调接收者对象的相应方法，让接收者来真正执行功能
		receiver.action();
	}
}
