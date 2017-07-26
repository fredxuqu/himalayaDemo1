package com.himalaya.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.service.HimalayaService;

public class HimalayaServiceImplTest extends BaseTestCase {

	@Autowired
	HimalayaService himalayaService;

	@Before
	public void setup() throws Exception {
		
	}
	
	@Test
	public void testService() throws Exception {
		LOGGER.info("Count : " + himalayaService.service(""));
	}
}
