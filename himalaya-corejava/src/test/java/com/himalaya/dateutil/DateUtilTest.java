package com.himalaya.dateutil;

import java.util.Date;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年3月15日 下午5:02:39
* Description
*/
public class DateUtilTest {

	public static void main(String[] args) {
		
		Date d1 = new Date();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date d2 = d1;
		
		System.out.println(d1.before(d2));
		System.out.println(d2.after(d2));
		System.out.println(d2.equals(d2));
	}
}
