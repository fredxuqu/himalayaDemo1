package com.himalaya;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himalaya.dto.UserDTO;
import com.himalaya.service.HimalayaService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:35:58
* Description
*/
public class Consumer {

	private final static Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		context.start();

		HimalayaService service = (HimalayaService) context.getBean("himalayaService");
		String result = service.login("tom"); 
		LOGGER.info(result);

		List<UserDTO> list = service.service();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				LOGGER.info(list.get(i).toString());
			}
		}
		LOGGER.info("Consumer is running...");
		System.in.read();
	}
}