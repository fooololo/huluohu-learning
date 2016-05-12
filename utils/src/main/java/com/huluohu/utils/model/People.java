package com.huluohu.utils.model;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/12
 * Time           :   18:14
 * Description    :
 */
public class People {
	private String name;
	private int	age;
	private Address address;
	private Book book;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
