package com.himalaya;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTestCase {
	
	protected ApplicationContext context;
	
//	@Value("#{propertiesReader[host]}")
//	protected String host;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
}