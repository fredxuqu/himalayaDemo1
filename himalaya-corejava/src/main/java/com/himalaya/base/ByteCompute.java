package com.himalaya.base;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月18日 上午9:53:07
* Description
*/
public class ByteCompute {

	public static void main(String[] args) {
		
		int i = 1;
		//1000000000000000000000000000000
		// i << 1 equals i*2
		System.out.println(i + "<<30");
		System.out.println(i + " " + Integer.toBinaryString(i));
		System.out.println((i << 30) + " " + Integer.toBinaryString(i << 30));
		System.out.println(Math.pow(2, 30));
		
		// i >> 1 equals i/2
		System.out.println(i + ">>1");
		System.out.println(i + " " + Integer.toBinaryString(i));
		System.out.println((i >> 1) + " " + Integer.toBinaryString(i >> 1));
		
		/* 
		 * i >>> 1 equals i/2
		 * 1100
		 */
		System.out.println(i + ">>>1");
		System.out.println(i + " " + Integer.toBinaryString(i));
		System.out.println((i >>> 1) + " " + Integer.toBinaryString(i >>> 1));
		
		int j = -2;
		/*
		 * 无符号右移，忽略符号位扩展，即符号位也算数值
		 * 11111111111111111111111111111110
		 *	>>> 1
		 * 01111111111111111111111111111111
		 */
		System.out.println(j + ">>>1");
		System.out.println(j + " " + Integer.toBinaryString(j));
		System.out.println((j >>> 1) + " " + Integer.toBinaryString(j >>> 1));
		
		
		
	}
}
