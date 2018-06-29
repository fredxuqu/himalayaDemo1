package com.himalaya.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.himalaya.BaseTestCase;
import com.himalaya.solr.client.impl.QueryServiceImpl;

public class UserDaoImplTest extends BaseTestCase{
	
	private final Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

	@Value("oracle.jdbc.driverClassName")
	private String driverName;
	
//	@Autowired
//	private UserDao userDao;

	@Before
	public void setUp()throws Exception{
		System.out.println("---------------------- " + driverName);
	}
	
	@Test
	public void testGetProductList(){
		try {
			logger.debug("Testing executed.................." + driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

