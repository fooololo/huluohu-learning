package com.huluohu.utils.model;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/12
 * Time           :   18:15
 * Description    :
 */
public class Book {
	private String id;
	private String	name;
	private String	author;
	private double	price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
