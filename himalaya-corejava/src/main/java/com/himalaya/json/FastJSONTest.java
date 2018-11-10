package com.himalaya.json;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年9月12日 下午2:57:08
* Description
*/
public class FastJSONTest {

	// String to JSON
	@Test
	public void testStringToJSON(){
	    String str = "{\"age\":\"24\",\"name\":\"cool_summer_moon\"}";  
	    JSONObject  jsonObject = JSONObject.parseObject(str);
	    System.out.println("json对象是：" + jsonObject);
	    Object object = jsonObject.get("name");
	    System.out.println("name值是："+object);
	}
	
	// JSON to String
	@Test
	public void testJSON2String(){
	    String str = "{\"age\":\"24\",\"name\":\"cool_summer_moon\"}";
	    JSONObject  jsonObject = JSONObject.parseObject(str);
	    //json对象转字符串
	    String jsonString = jsonObject.toJSONString();
	    System.out.println("json字符串是：" + jsonString);
	}
	
	// String to Map 
	@Test
	public void testString2Map(){
	    String str = "{\"age\":\"24\",\"name\":\"cool_summer_moon\"}";
	    JSONObject  jsonObject = JSONObject.parseObject(str);
	    //json对象转Map
	    Map<String,Object> map = (Map<String,Object>)jsonObject;
	    System.out.println("map对象是：" + map);
	    Object object = map.get("age");
	    System.out.println("age的值是"+object);
	}
	
	// Map to String 
	@Test
	public void testMap2String(){
	    Map<String,Object> map = new HashMap<>();
	    map.put("age", 24);
	    map.put("name", "cool_summer_moon");
	    String jsonString = JSON.toJSONString(map);
	    System.out.println("json字符串是："+jsonString);
	}
	
	// Map to JSON
	@Test
	public void testMap2JSON(){
	    Map<String,Object> map = new HashMap<>();
	    map.put("age", 24);
	    map.put("name", "cool_summer_moon");
	    JSONObject json = new JSONObject(map);
	    System.out.println("Json对象是：" + json);
	}
}