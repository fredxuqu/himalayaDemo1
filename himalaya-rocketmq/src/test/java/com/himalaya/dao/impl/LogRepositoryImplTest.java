package com.himalaya.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.model.LogInfo;
import com.himalaya.repository.LogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LogRepositoryImplTest {

	@Autowired
	private LogRepository logRepository;
	
	@Before 
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	 
	@Test
	public void testInsert(){
		List<LogInfo> logs = new ArrayList<LogInfo>();
		LogInfo log = new LogInfo();
		log.setId("log0003");
		log.setMsg("DB exception!");
		log.setLogLevel(1);
		log.setAppId("Normalize");
		
		LogInfo log2 = new LogInfo();
		log2.setId("log0004");
		log2.setMsg("DB exception qqid!");
		log2.setLogLevel(1);
		log2.setAppId("Normalize");
		
		logs.add(log);
		logs.add(log2);
		logRepository.insert(logs);
				
		System.out.println("---------------------------------------");
		List<LogInfo> list = logRepository.findAll();
		for (LogInfo logEntiy : list) {
			System.out.println(logEntiy);
		}
	}	
}
