package com.himalaya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:35:58
* Description
*/
public class Provider {

	private final static Logger LOGGER = LoggerFactory.getLogger(Provider.class);
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		context.start();

//		while(true){
//			Thread.sleep(5000);
//			LOGGER.info("Provider is running...");
//		}
		LOGGER.info("Provider is running...");
		System.in.read();
	}
}