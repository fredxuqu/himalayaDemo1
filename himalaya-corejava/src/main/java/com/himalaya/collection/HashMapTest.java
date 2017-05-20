package com.himalaya.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", "1");
		map.put("city", "2");
		map.put("county", "3");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + " - " + map.get(key));
		}
	}
}
