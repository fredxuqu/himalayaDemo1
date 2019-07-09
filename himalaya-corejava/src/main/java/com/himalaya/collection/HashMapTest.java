package com.himalaya.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	
	public static Map<String, Integer> sortByValue(Map<String, Integer> inputMap){
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(inputMap.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				if(entry1.getValue() > entry2.getValue()){
					return 1;
				} else if(entry1.getValue() < entry2.getValue()){
					return -1;
				} else {
					return 0;
				}
			}
		});
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		list.forEach(item->{
			linkedHashMap.put(item.getKey(), item.getValue());
		});
		return linkedHashMap;
	}
	
	public static Map<String, Integer> sortByValue2(Map<String, Integer> inputMap){
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		inputMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(item->{
			linkedHashMap.put(item.getKey(), item.getValue());
		});
		return linkedHashMap;
	}
	
	public static Map<String, Integer> sortByKey(Map<String, Integer> inputMap){
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		inputMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey())
		.forEach(item->{
			linkedHashMap.put(item.getKey(), item.getValue());
		});
		return linkedHashMap;
	}

	// remove duplicated item from list
	public static void removeDuplicatedItemFormList(List<String> list){
		Set<String> linkedHashSet = new LinkedHashSet<String>(list);
		linkedHashSet.forEach(item->{
			System.out.println(item);
		});
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("2","3","2","3","2","3","2","3","35","88");
		removeDuplicatedItemFormList(list);
		
		Map<String, Integer> original = new HashMap<String, Integer>();
		original.put("A", 3);
		original.put("B", 0);
		original.put("C", 5);
		original.put("D", 1);
		print(original);
		System.out.println();
		print(sortByKey(original));
		
		System.out.println();
		print(sortByValue(original));
		
		System.out.println();
		print(sortByValue2(original));
		
		int size = 100000000;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		
		long start = System.currentTimeMillis();
		int sum = sum(array);
		System.out.println(sum);
		System.out.println("liner total cost " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		sum = recursionSum(array, 0 , size-1);
		System.out.println(sum);
		System.out.println("recursion total cost " + (System.currentTimeMillis() - start));
	}
	
	private static int sum(int[] array) {
		int sum = 0;
		for (int j = 0; j < array.length; j++) {
			sum += array[j];
		}
		return sum;
	}
	
	private static int recursionSum(int[] array, int low, int high) {
		if (low == high){
			return array[low];
		}
		int mid = (low + high) >> 1;
		return recursionSum(array, low, mid) + recursionSum(array, mid + 1, high);
	}


	private static void print(List<Entry<String, Integer>> list) {
		list.forEach(item->{
			System.out.println(item.getKey() + " " + item.getValue());
		});
	}

	static void print(Map<String, Integer> original){
		Set<Entry<String, Integer>> list = original.entrySet();
		list.forEach(item->{
			System.out.println(item.getKey() + " " + item.getValue());
		});
	}
}
