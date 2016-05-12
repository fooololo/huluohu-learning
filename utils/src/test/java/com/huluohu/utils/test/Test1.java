package com.huluohu.utils.test;

import com.alibaba.fastjson.JSON;
import com.huluohu.utils.log.SystemLog;
import com.huluohu.utils.model.Address;
import com.huluohu.utils.model.Book;
import com.huluohu.utils.model.People;
import org.junit.Test;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/12
 * Time           :   18:18
 * Description    :
 */
public class Test1 {
	@Test
	public void testFastjson(){
		Address address = new Address();
		address.setProvince("北京");
		address.setCity("北京市");
		address.setArea("海淀区");

		Book book = new Book();
		book.setId("BNOKOHKK1234");
		book.setName("这是一本书");
		book.setAuthor("作者");
		book.setPrice(123.33D);

		People people = new People();
		people.setName("小明");
		people.setAge(12);
		people.setAddress(address);
		people.setBook(book);
		String json = JSON.toJSONString(people);
		SystemLog.info(json);
		People p = JSON.parseObject(json,People.class);
		SystemLog.info(p.getName());
	}
}
