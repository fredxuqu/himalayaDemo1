package com.himalaya.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月4日 下午2:05:59
* Description
*/
public class TaskExecuter implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(TaskExecuter.class);
	
	public TaskExecuter(){
		
	} 
	
	@Override
	public void run() {
		while(true){
			logger.info("TaskExecuter executing...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
