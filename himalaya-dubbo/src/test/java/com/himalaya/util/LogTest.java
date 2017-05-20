package com.himalaya.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.himalaya.BaseTestCase;

public class LogTest extends BaseTestCase {

	private final Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLogging(){
		
		logger.debug("debug log....");
		logger.info("info log....");
		logger.warn("warn log....");
		logger.error("error log....");
		System.out.println("system out println....");
	}
}
