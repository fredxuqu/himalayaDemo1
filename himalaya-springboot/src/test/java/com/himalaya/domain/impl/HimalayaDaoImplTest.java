package com.himalaya.domain.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.domain.HimalayaDao;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月26日 上午11:05:36
* Description
*/
public class HimalayaDaoImplTest extends BaseTestCase {
	
	@Autowired
	HimalayaDao himalayaDao;
	
	@Test
	public void testCount(){
		
		LOGGER.info("Database connected successful " + himalayaDao.count());
	}
}
