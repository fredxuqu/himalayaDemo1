package com.himalaya.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月14日 下午8:22:32
* Description
*/
public class TextHandler {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		String sourceFile = "config/sourcecodes.txt";
		URL sourceURL = Thread.currentThread().getContextClassLoader().getResource(sourceFile);
		String targetFile = "config/luceneanalysis.txt";
		URL targetURL = Thread.currentThread().getContextClassLoader().getResource(targetFile);
		
		System.out.println(URLDecoder.decode(sourceURL.getPath(), "UTF-8"));
		try {
			reader = new BufferedReader(new FileReader(new File(URLDecoder.decode(sourceURL.getPath(), "UTF-8"))));
			writer = new BufferedWriter(new FileWriter(new File(URLDecoder.decode(targetURL.getPath(), "UTF-8"))));
			
			String line = null;
			while((line=reader.readLine())!=null){
				
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
