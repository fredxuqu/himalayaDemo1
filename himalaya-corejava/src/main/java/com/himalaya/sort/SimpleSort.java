package com.himalaya.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SimpleSort {
	
	public static void bubbleSort(int[] array){
		
		boolean sorted = false;
		
		for (int i = 0; i < array.length & !sorted; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					sorted = false;
				}
			}
		}
	}
	
	public static void insertSort(int[] array){
		
		for (int i = 1; i < array.length; i++) {
			
			int key = array[i];
			int position = i;
			
			while(position > 0 && array[position-1] > key){
				array[position] = array[position-1];
				position--;
			}
			array[position] = key;
		}
	}
	
	public static void selectSort(int[] array){
		for (int i = 0; i < array.length; i++) {
			int minindex = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[j] < array[minindex]){
					minindex = j;
				}
			}
			if(minindex != i){
				int temp = array[minindex];
				array[minindex] = array[i];
				array[i] = temp;
			}
		}
	}
	
	public static void quickSort(int[] array, int min, int max){
		if (min < max){
			int index = findPartition(array, min, max);
			quickSort(array, min, index-1);
			quickSort(array, index + 1, max);
		}
	}
	
	// 找到一个位置，将大于这个位置的数都放到右边，小于这个数的都放到左边
	// 12, 11, 13, 45, 0, -1, -1000, -1, 1000
	public static int findPartition(int[] array, int min, int max){
		
		int left = min;
		int right = max;
		int partition = min;
		int temp = 0;
		while(left < right){
			while(array[left] <= array[partition] && left < right){
				left++;
			}
			while(array[right] > array[partition]){
				right--;
			}
			if (left <  right){
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		
		temp = array[min];
		array[min] = array[right];
		array[right] = temp;
		return right;
	}
	
	private static void print(int[] list){
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		int[] list = new int[]{12, 11, 13, 45, 0, -1, -1000, -1, 1000};
		print(list);
		System.out.println("---------- Bubble Sorting ------------");
//		bubbleSort(list);
//		print(list);
//		insertSort(list);
//		print(list);
//		selectSort(list);
//		print(list);
		quickSort(list, 0, list.length-1);
		print(list);
	}
}
