package com.huluohu.learning.dp.command;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/31
 * Time           :   18:10
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		Receiver 	receiver 	= 	new Receiver();
		Command 	command		=	new ConcreteCommand(receiver);
		Invoker		invoker		=	new Invoker(command);
		invoker.action();
	}
}
