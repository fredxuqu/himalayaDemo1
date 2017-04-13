package com.himalaya.dbutils;

import org.junit.Test;

// use below command to encrypt password 
// java -cp D:/druid-1.0.13.jar com.alibaba.druid.filter.config.ConfigTools sa
// 明文密码+私钥(privateKey)加密=加密密码
// 加密密码+公钥(publicKey)解密=明文密码
public class DruidUtilsTest {
	
	private static String CMD = "java -cp E:/solr/solr-6.3.0/server/lib/ext/druid-1.0.27.jar com.alibaba.druid.filter.config.ConfigTools password";
	
	@Test
	public void test(){
		System.out.println(CMD);
	}
	
	@Test
	public void testEncrypt(){
		try {
			System.out.println("encoded :" + DecryptUtils.encode("sa"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDecrypt(){
		try {
			System.out.println("decoded :" + new String(DecryptUtils.decode(DecryptUtils.encode("sa"))));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
