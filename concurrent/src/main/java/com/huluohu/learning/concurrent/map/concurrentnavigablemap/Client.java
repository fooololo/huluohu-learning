package com.huluohu.learning.concurrent.map.concurrentnavigablemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   14:06
 * Description    :ConcurrentNavigableMap 是一个支持并发访问的 java.util.NavigableMap，
 * 它还能让它的子 map 具备并发访问的能力。所谓的 "子 map" 指的是诸如 headMap()，subMap()，tailMap() 之类的方法返回的 map
 */
public class Client {
	public static void main(String[] args) {
		ConcurrentNavigableMap<String,Object> map = new ConcurrentSkipListMap<>();
		map.put("k1","v1");
		map.put("k2","v2");
		map.put("k3","v3");
		map.put("k4","v4");

		//小于toKey
//		ConcurrentNavigableMap<String, Object> sub = map.headMap("k4");
		//大于等于fromKey，小于toKey
//		ConcurrentNavigableMap<String, Object> sub = map.subMap("k2","k4");
		//大于等于fromKey
		ConcurrentNavigableMap<String, Object> sub = map.tailMap("k2");

		Set<Map.Entry<String, Object>> entries = sub.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
		while (iterator.hasNext()){
			Map.Entry<String, Object> next = iterator.next();
			System.out.println(next.getKey());
			System.out.println(next.getValue());
		}
	}
}
