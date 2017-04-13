package com.himalaya;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class JsonTestCase {
	
	protected ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public void testMergeJsonObject(){
		
		String jsonArrStr = "{\"employees\":[{\"ID\": \"135\", \"Name\": \"Fargo Chan\" },{ \"ID\": \"432\", \"Name\": \"Aaron Luke\" },{ \"ID\": \"252\", \"Name\": \"Dilip Singh\" }]}";
        JSONObject jsonOne = new JSONObject(jsonArrStr);
		JSONObject jsonTwo = new JSONObject();  

  
        jsonTwo.put("hobbit", "Dota");  
        jsonTwo.put("hobbit2", "wow"); 
        JSONArray array = jsonOne.getJSONArray("employees");
        for (int i = 0; i < array.length(); i++) {
			JSONObject object = (JSONObject)array.get(i);
			System.out.println(object);
			System.out.println(object.get("Name"));
		}
        //System.out.println(jsonOne.getJSONArray("employees"));
	}
}
