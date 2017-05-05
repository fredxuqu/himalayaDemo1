package com.himalaya.solr.client.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.model.AddressDO;

public class IndexServiceImplTest extends BaseTestCase{
	
	private final Logger logger = LoggerFactory.getLogger(IndexServiceImplTest.class);
	
	@Autowired
	private IndexServiceImpl iService; 
	
	@Before
	public void setUp()throws Exception{
		
		super.setUp();
	}
	
	@Test
	public void testQueryHotestTags() {
		try {
			AddressDO addressDO = new AddressDO();
			addressDO.setId(10001);
			addressDO.setProvinceCode("43");
			addressDO.setProvinceName("湖南省");
			addressDO.setCityCode("4301");
			addressDO.setCityName("长沙市");
			addressDO.setCountyCode("430121");
			addressDO.setCountyName("长沙县");
			addressDO.setAddress("华润万象汇");
			addressDO.setLatitude(120.8855);
			addressDO.setLongitude(55.4565);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
