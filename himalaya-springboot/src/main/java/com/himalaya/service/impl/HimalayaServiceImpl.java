package com.himalaya.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himalaya.domain.HimalayaDao;
import com.himalaya.service.HimalayaService;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年7月26日 上午9:13:16 Description
 */
@Service
public class HimalayaServiceImpl implements HimalayaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HimalayaServiceImpl.class);
	
	@Autowired
	private HimalayaDao himalayaDao;
	
	@Override
	public int service(String param) {
		
		return himalayaDao.count();
	}
}
