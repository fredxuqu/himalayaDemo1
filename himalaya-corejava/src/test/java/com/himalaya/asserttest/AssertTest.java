package com.himalaya.asserttest;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月12日 下午4:48:28
* Description
*/
public class AssertTest {

	// should set JVM parameter "-ea" to enable assert
	public static void main(String[] args) {
		
		boolean flag = true;
		while(flag){
			assert flag;
			System.out.println("assert is true, continue....");
			flag = false;
			assert flag : "assert failed, exit....";
		}
	}
}
