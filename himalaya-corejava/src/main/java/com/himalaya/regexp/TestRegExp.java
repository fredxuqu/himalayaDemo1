package com.himalaya.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月14日 下午4:09:56
* Description
*/
public class TestRegExp {

	public static void main(String[] args) {
		
		String regExp = "o{2,}";
		
		Pattern pattern = Pattern.compile(regExp);
		
		String str = "44ooooo";
		Matcher match = pattern.matcher(str);
		if(match.matches()){
			System.out.println("Matched!");
		} else {
			System.out.println("Not matched!");
		}
		
		int a = 0;
		switch (a) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		default:
			System.out.println("Other");
		}
	}
}
