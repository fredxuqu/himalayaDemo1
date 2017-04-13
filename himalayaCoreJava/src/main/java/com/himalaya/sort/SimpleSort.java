package com.himalaya.sort;

import java.util.ArrayList;
import java.util.List;

public class SimpleSort {
	
	public static void bubbleSort(List<Integer> array){
		
		boolean sorted = false;
		
		for (int i = 0; i < array.size() & !sorted; i++) {
			for (int j = 0; j < array.size()-i-1; j++) {
				if(array.get(j)>array.get(j+1)){
					int temp = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, temp);
					sorted = false;
				}
			}
		}
	}
	
	private static void print(List<Integer> list){
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(11);
		list.add(12);
		list.add(15);
		list.add(-1);
		list.add(2);
		list.add(1001);
		list.add(89);
		print(list);
		System.out.println("---------- Bubble Sorting ------------");
		bubbleSort(list);
		print(list);
	}
}
