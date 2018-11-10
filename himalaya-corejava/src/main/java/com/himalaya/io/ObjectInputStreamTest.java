package com.himalaya.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年9月11日 下午5:01:19
* Description
*/
public class ObjectInputStreamTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "1001");
		map.put("name", "fred");
		objectOutputStream.writeObject(map);
		byte[] mapByte = byteArrayOutputStream.toByteArray();
		System.out.println(mapByte);
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mapByte);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		Map<String, String> mapp = (Map<String, String>)objectInputStream.readObject();
		System.out.println(mapp);
	}
}
