package com.himalaya.dbutils;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DecryptUtils {
	
	public static String encode(String secret) throws Exception{
		
		byte[] kbytes = "jaas is the way".getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(1, key);
		byte[] encoding = cipher.doFinal(secret.getBytes());
		BigInteger n = new BigInteger(encoding);
		return n.toString(16);
	}
	
	public static char[] decode(String secret) throws Exception{
		
		byte[] kbytes = "jaas is the way".getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");
		
		BigInteger n = new BigInteger(secret, 16);
		
		byte[] encoding = n.toByteArray();
		if(encoding.length % 8 != 0){
			int length = encoding.length;
			int newLength = (length / 8 + 1) * 8;
			int pad = newLength - length;
			byte[] old = encoding;
			encoding = new byte[newLength];
			for(int i=old.length; i>=0 ; i--){
				encoding[(i+pad)]=old[i];			
			}
		}
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(2, key);
		byte[] decode = cipher.doFinal(encoding);
		return new String(decode).toCharArray();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("encoded :" + encode("sa"));			
			
			System.out.println("decoded :" + new String(decode(encode("sa"))));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
