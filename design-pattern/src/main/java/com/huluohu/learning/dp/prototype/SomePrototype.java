package com.huluohu.learning.dp.prototype;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/14
 * Time           :   16:36
 * Description    :
 */
public class SomePrototype implements Prototype,Cloneable {
	private int size;

	public SomePrototype(int size) {
		this.size = size;
	}

	@Override public void setSize(int x) {
		this.size = x;
	}

	@Override public void printSize() {
		System.out.println("size is " + size);
	}

	@Override protected SomePrototype clone() throws CloneNotSupportedException {
		return (SomePrototype)super.clone();
	}
}
