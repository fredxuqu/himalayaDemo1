package com.himalaya.config;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;

public class DruidDBConfigTest extends BaseTestCase {

	@Autowired
	DruidDBConfig druidDBConfig;

	@Before
	public void setup() throws Exception {
		
	}
	
	@Test
	public void testService() throws Exception {
		druidDBConfig.dataSource().hashCode();
		LOGGER.info("" + druidDBConfig.dataSource().hashCode());
	}
}
