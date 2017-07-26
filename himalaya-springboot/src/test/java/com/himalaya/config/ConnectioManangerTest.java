package com.himalaya.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年7月26日 下午2:53:00 Description
 */
public class ConnectioManangerTest extends BaseTestCase {
	
	@Autowired
	ConnectionManager connectionManager;

	@Before
	public void setup() throws Exception {

	}

	@Test
	public void testService() throws Exception {
		Connection conn = connectionManager.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select count(*) count from products");
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		LOGGER.info("Count is " + count);
	}
}
