package com.himalaya.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.himalaya.dbutils.DecryptUtils;

public class DecryptDruidDataSource extends DruidDataSource {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void setPassword(String password) {
		try {
			if(password!=null && password.indexOf("MD5")!=-1){
				System.out.println("Encrypt password is " + password);
				char[] decrypted = DecryptUtils.decode(password);
				password = new String(decrypted);
				System.out.println("Plain text password is " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setPassword(password);
	}
}
