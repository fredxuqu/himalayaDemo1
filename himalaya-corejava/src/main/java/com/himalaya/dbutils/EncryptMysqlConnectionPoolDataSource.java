package com.himalaya.dbutils;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年12月21日 下午5:40:04 Description
 */
public class EncryptMysqlConnectionPoolDataSource extends MysqlConnectionPoolDataSource {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	public EncryptMysqlConnectionPoolDataSource() throws SQLException {
//		super();
//	}

	public synchronized void setPassword(String paramString) {
		
		// Encrypt password
		System.out.println("=====================Set Password========================== "
								+ paramString);
		this.password = paramString;
	}
}
