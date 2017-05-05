package com.himalaya.solr.client.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;

public class QueryServiceImplTest extends BaseTestCase{
	
	private final Logger logger = LoggerFactory.getLogger(QueryServiceImplTest.class);
	
	@Autowired
	private QueryServiceImpl iService; 
	
	@Before
	public void setUp()throws Exception{
		
		super.setUp();
	}
	
	@Test
	public void testQueryHotestTags() {
		try {
			
			logger.info("Search Result : " + iService.queryHotestTags("", 5, 0));
			Assert.assertEquals(5, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTags0() {
		try {
			logger.info("Search Result : " + iService.queryTags("西藏", 5, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryPosition() {
		try {
			logger.info("Search Result : " + iService.queryByPosition("", "121.8950 56.4565", 5, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
