package com.himalaya.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.himalaya.dto.UserDTO;
import com.himalaya.service.HimalayaService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:29:25
* Description
*/
public class HimalayaServiceImpl implements HimalayaService {

	@Override
	public List<UserDTO> service() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(new UserDTO(1, "Fred", "123456"));
		list.add(new UserDTO(2, "Anna", "123456"));
		list.add(new UserDTO(3, "Wendy", "123456"));
		return list;
	}

	@Override
	public String login(String userName) {
		System.out.println(userName + " login.");
		
		return userName + " login info";
	}
}
