package com.himalaya.jsonutils;

import java.util.Date;

import com.alibaba.fastjson.JSON;

public class JSONUtils {

	public static String fromObjectToJSON(Object object){
		return JSON.toJSONString(object);
	}
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("Fred");
		user.setRegisterTime(new Date());		
		System.out.println(JSONUtils.fromObjectToJSON(user));
	}
}
