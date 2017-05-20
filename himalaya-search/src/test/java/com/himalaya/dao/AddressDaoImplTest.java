package com.himalaya.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.himalaya.BaseTestCase;
import com.himalaya.model.AddressDO;

public class AddressDaoImplTest extends BaseTestCase{
	
	private final Logger logger = LoggerFactory.getLogger(AddressDaoImplTest.class);

	@Value("oracle.jdbc.driverClassName")
	private String driverName;
	
	@Autowired
	private AddressDAO addressDAO;

	@Before
	public void setUp()throws Exception{
		logger.info("===========driverName : " + driverName);
	}
	
	@Test
	public void testGetAddressByPage(){
		try {
			List<AddressDO>  list = addressDAO.getAddressByPage(10, 20);
			logger.info("address list size : " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

