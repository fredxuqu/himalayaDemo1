package com.himalaya;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:35:58
* Description
*/
public class Provider {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		context.start();

		while(true){
			Thread.sleep(5000);
			System.out.println("Provider is running...");
		}
	}
}