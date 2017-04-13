package com.himalaya.service.impl;

import com.alibaba.fastjson.JSON;
import com.himalaya.model.User;
import com.himalaya.service.IService;

public class ServiceImpl implements IService{
	
	//http://localhost:8090/himalayaWebService/services/searchService/setUser
	@Override
    public void setUser() {   
		System.out.println("Call serUser");
    }

	//http://localhost:8090/himalayaWebService/services/searchService/service?username=fred
	@Override
	public String service(String username)throws Exception {
		try {	
		
			System.out.println("Call service : " + username);
			
			System.out.println(JSON.toJSONString(username));
			//if(!"fred".equals(username)){
			//	throw new RuntimeException("Parameter error");
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Hello " + username;  
	}

	@Override
	public String parseUser(User user) throws Exception {
		System.out.println(JSON.toJSONString(user));
		return "success";
	}
}
