package com.himalaya.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.himalaya.BaseTestCase;
import com.himalaya.dao.ForumDao;
import com.himalaya.model.ForumDO;

public class TestForumDao extends BaseTestCase{
	
	private final Logger logger = LoggerFactory.getLogger(TestForumDao.class);

	@Value("mysql.jdbc.driverClassName")
	private String driveName;
	
	@Autowired
	private ForumDao<ForumDO> forumDao;
	
	@Before
	public void setUp()throws Exception{
		System.out.println("************** " + driveName);
	}
	
	@Test
	public void testCreateTable(){
		try {
			System.out.println("************** " + forumDao.hashCode());
			List<ForumDO> list = forumDao.getForumList();
			for (ForumDO forumDO : list) {
				logger.info("&&& " + forumDO.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
