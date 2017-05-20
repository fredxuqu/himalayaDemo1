package com.himalaya.string;

import org.junit.Test;

import com.himalaya.BaseTest;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月5日 上午8:52:51
* Description
*/
public class StringUtilsTest extends BaseTest{
	
	@Test
	public void testParams(){
		String[] params = {"123","456"};
		execute(params);
		
		String str = null;
		System.out.println("[" + str + "]");
	}
	
	// regular expression test
	@Test
	public void testSubString(){
				
		String str = "人文科技h";
		System.out.println(str.substring(0, str.length()-1));
		System.out.println(str.substring(str.length()-1, str.length()));
	}
		
	// regular expression test
	@Test
	public void testRegExp(){
				
		String str = "^2^3da42b3中文sae34科技b2  报2`~!@#$%^&*()_+-=[]{};':\",.<>/?\\93飞";
		// remove all characters except Chinese
		str = str.replaceAll("[^\\u4e00-\\u9fa5\\ ]", "");
		System.out.println(str);
		
		// remove all characters except English character
		str = "^2^3da42b3中文sae34科e技b2报2`~!@#$%^&*()_+-=[]{};':\",.<>/?\\93飞";
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);
	}
	
	private void execute(String[] args){
		
	}
}
