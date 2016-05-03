package com.huluohu.learning.concurrent.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/3
 * Time           :   9:13
 * Description    :
 */
public class Client {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		List<String> list = new ArrayList<>();
		list.add("awdae");
		list.add("dasfdf");
		list.add("fghthb");
		list.add("4e543f");
		list.add("vjghh");

		List<String> sub = new ArrayList<>();
		list.add("aaaaaa");
		list.add("bbbb");

		Stream<String> sorted = list.stream()//转换成Stream
				.filter(s -> s.length() > 5)//过滤
				.map(s -> s.concat("ddd"))//元素转换
				.flatMap(s -> Arrays.asList(s.split(",")).stream())//子元素再次抽取
				.peek(s -> System.out.println(s))//对原始执行额外操作s
				.distinct()//去重
				.sorted()//排序
				.limit(3)// 保证后续的操作所能看到的最大数量的元素
				;
		System.out.println(Arrays.toString(sorted.toArray()));
	}
}
