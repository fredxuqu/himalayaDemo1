package com.himalaya.service.impl;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;

public class ServiceImplTest extends BaseTestCase{
	
	@Autowired
	private ServiceImpl iService; 
	
	@Before
	public void setUp()throws Exception{
		
		super.setUp();
	}
	
	@Test
	public void testQueryHotestTags() {
		try {
			System.out.println(iService.queryHotestTags("*:*", 5, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTags0() {
		try {
			System.out.println(iService.queryTags("����", 5, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTags1() {
		try {
			JSONArray array = new JSONArray(iService.queryTags("����", 5, 0));
			Assert.assertEquals(2,array.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTags3() {
		try {
			JSONArray array = new JSONArray(iService.queryTags("ŮƱ", 5, 0));
			Assert.assertEquals(1,array.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTags4() {
		try {
			JSONArray array = new JSONArray(iService.queryTags("ȥ", 2, 1));
			System.out.println(array.toString());
			Assert.assertEquals(2,array.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
