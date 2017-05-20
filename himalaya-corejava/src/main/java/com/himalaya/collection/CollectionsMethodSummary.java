package com.himalaya.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class CollectionsMethodSummary {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>(Collections.nCopies(4, "1234"));
		print(list);
		
		Collections.fill(list, "fred");
		print(list);
		
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		Integer[] ints = {7,8};
		Collections.addAll(intList, ints);
		print(intList);
		
		print(intList.iterator());
		print(intList.listIterator());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "fred");
		map.put("grade", "1");
		List<String> values = new ArrayList<String>(map.values());
		print(values);
	}
	
	private static void print(List<? extends Object> list){
		System.out.println();
		for (Object string : list) {
			System.out.print(string + " ");
		}
	}
	
	private static void print(Iterator<? extends Object> it){
		System.out.println("Iterator ....");
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
	}
	
	private static void print(ListIterator<? extends Object> it){
		System.out.println("Iterator ....");
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		while(it.hasPrevious()){
			System.out.print(it.previous() + " ");
		}
	}
}
