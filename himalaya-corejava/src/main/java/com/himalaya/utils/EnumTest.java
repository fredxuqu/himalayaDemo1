package com.himalaya.utils;

public class EnumTest { 
	
	public static void main(String[] args) {
		
		String str = "a|b|c| |";
		String[] ary = str.split("[|]");
		//????3,???3
		System.out.println(ary.length);
		System.out.println(EnumDemo.Normal.getKey() + EnumDemo.Normal.getValue());
	}
}
