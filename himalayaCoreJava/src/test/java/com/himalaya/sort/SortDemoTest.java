package com.himalaya.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortDemoTest {
	int[] elements = {12,23,2,1,100,1909,4,-1};
	
	@Before
	public void setUp() throws Exception {
		print();
	}

	@After
	public void tearDown() throws Exception {
		print();
	}
	
	@Test
	public void testCollectionsSort(){
		
		//Collections.sort(null);
	}
	
	private void print(){
		for (int i : elements) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/**
	 12,23,2,1,100,1909,4,-1
	 assume that the first element is sorted.
	 */
	@Test
	public void testInsertSort(){
		
		for(int i=1; i<=elements.length-1; i++){
			
			if(elements[i]<elements[i-1]){
				int temp = elements[i];
				elements[i] = elements[i-1];
				int j = i-1;
				for (; j>0 && elements[j-1]>temp; j--) {
					elements[j]=elements[j-1];
				}
				elements[j]=temp;
			}
		}
	}
	
	/**
	 12,23,2,1,100,1909,4,-1
	 assume that the first element is sorted.
	 */
	@Test
	public void testBubbleSort(){	
		boolean isSorted = false;
		for(int i=0; i<=elements.length-1 && !isSorted; i++){
			isSorted = true;
			for(int j=i+1; j<=elements.length-1; j++){
				if(elements[i]>elements[j]){
					int temp = elements[i];
					elements[i] = elements[j];
					elements[j]=temp;
					isSorted = false;
				}
			}
		}
	}
}
