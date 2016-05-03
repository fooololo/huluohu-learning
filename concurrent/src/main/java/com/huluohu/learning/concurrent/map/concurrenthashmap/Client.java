package com.huluohu.learning.concurrent.map.concurrenthashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/4/6
 * Time           :   11:20
 * Description    :ConcurrentHashMap 和 java.util.HashTable 类很相似，
 * 但 ConcurrentHashMap 能够提供比 HashTable 更好的并发性能。
 * 在你从中读取对象的时候 ConcurrentHashMap 并不会把整个 Map 锁住。
 * 此外，在你向其中写入对象的时候，ConcurrentHashMap 也不会锁住整个 Map。
 * 它的内部只是把 Map 中正在被写入的部分进行锁定。
 */
public class Client {
	public static void main(String[] args) {
		ConcurrentMap<String,Object> map = new ConcurrentHashMap<>();
		map.put("k1","v1");
		map.put("k2","v2");
		map.put("k3","v3");
		map.put("k4","v4");

		Set<Map.Entry<String, Object>> entries = map.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
		while (iterator.hasNext()){
			Map.Entry<String, Object> entry = iterator.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
