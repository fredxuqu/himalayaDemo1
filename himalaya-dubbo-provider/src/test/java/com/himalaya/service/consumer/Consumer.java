package com.himalaya.service.consumer;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himalaya.dto.UserDTO;
import com.himalaya.service.HimalayaService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:55:19
* Description
*/
public class Consumer {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		HimalayaService demoService = (HimalayaService) context.getBean("himalayaService");
		String login = demoService.login("Tom");
		System.out.println(login);

		List<UserDTO> list = demoService.service();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
		System.in.read();
	}

}