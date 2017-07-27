package com.himalaya.jodatime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月27日 上午9:45:19
* Description
*/
public class JodaDemo {

	private static final String FORMATE_DATE = "yyyy-MM-dd";
	private static final String FORMATE_SECONDS = "HH:mm:ss";
	private static final String FORMATE_FULL = FORMATE_DATE.concat(" ").concat(FORMATE_SECONDS);
	
	private static final DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(FORMATE_FULL);    
    
	public static void main(String[] args) {
		
		// 将字符串转换成 DateTime
		String dateStr = "2017-07-23";
		String dateTimeStr = "2017-07-23 22:21:11";
		DateTime datetime = new DateTime();
		DateTime time = DateTime.parse(dateTimeStr, dateTimeFormat);
		System.out.println(time);
	}
}
