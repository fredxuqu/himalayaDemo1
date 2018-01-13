package com.himalaya.dbutils;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年12月21日 下午5:40:04 Description
 */
public class EncryptOracleDataSource extends OracleDataSource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncryptOracleDataSource() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public synchronized void setPassword(String paramString) {
		
		// Encrypt password
		this.password = paramString;
	}

	protected String getPassword() {
		return this.password;
	}
}
