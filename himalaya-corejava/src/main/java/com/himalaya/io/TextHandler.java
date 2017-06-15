package com.himalaya.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年6月14日 下午8:22:32 Description
 */
public class TextHandler {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = null;
		BufferedWriter writer = null;

		String sourceFile = "config/sourcecodes.txt";
		URL sourceURL = Thread.currentThread().getContextClassLoader().getResource(sourceFile);
		String targetFile = "config/luceneanalysis.txt";
		String absTargetFile = "C:/Users/xuqu/git/himalayaDemo/himalaya-corejava/src/main/resources/config/luceneanalysis.txt";
		URL targetURL = Thread.currentThread().getContextClassLoader().getResource(absTargetFile);

		System.out.println(URLDecoder.decode(sourceURL.getPath(), "UTF-8"));
		System.out.println(absTargetFile);
		try {
			reader = new BufferedReader(new FileReader(new File(URLDecoder.decode(sourceURL.getPath(), "UTF-8"))));
//			writer = new BufferedWriter(new FileWriter(new File(URLDecoder.decode(targetURL.getPath(), "UTF-8"))));
			writer = new BufferedWriter(new FileWriter(new File(absTargetFile)));

			String line = null;
			while ((line = reader.readLine()) != null) {

				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher isNum = pattern.matcher(line);
				if (!isNum.matches()) {
					System.out.println(line);
					writer.write(line);
					writer.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader!=null){
				reader.close();
			}
			if(writer!=null){
				writer.flush();
				writer.close();
			}
		}
	}
}
