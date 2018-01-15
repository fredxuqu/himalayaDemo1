package com.himalaya.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.dao.NewsDAO;
import com.himalaya.model.NewsDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-mysql.xml" })
public class TestNewsDao {

	private final Logger logger = LoggerFactory.getLogger(TestNewsDao.class);

	@Value("mysql.jdbc.driverClassName")
	private String driveName;

	@Autowired
	private NewsDAO<NewsDO> newsDAO;

	@Before
	public void setUp() throws Exception {
		System.out.println("************** " + driveName);
	}

	@Test
	public void testList() {
		try {
			System.out.println("************** " + newsDAO.hashCode());
			List<NewsDO> list = newsDAO.list();
			for (NewsDO newsDO : list) {
				logger.info("&&& " + newsDO.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
