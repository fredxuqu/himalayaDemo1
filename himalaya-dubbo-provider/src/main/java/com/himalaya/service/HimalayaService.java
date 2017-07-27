package com.himalaya.service;

import java.util.List;

import com.himalaya.dto.UserDTO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:28:45
* Description
*/
public interface HimalayaService {
	
	public List<UserDTO> service();
	
	public String login(String userName);
}
