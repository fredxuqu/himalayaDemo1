package com.himalaya.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.junit.Test;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年10月21日 下午2:36:21
* Description
*/
public class IOUtilTest {

	@Test
	public void testReadFile(){
		
		System.out.println();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("e:/synonyms.txt")));
			String line = null;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testAppendFile(){
		BufferedWriter writer = null;
        try {
        	writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/solr/solr-6.3.0/server/solr/iktest/conf/synonyms.txt"),false), "utf-8"));
//        	writer.append("aaafoo => aaabar");
//        	writer.newLine();
//        	writer.append("bbbfoo => bbbfoo bbbbar");
//        	writer.newLine();
//        	writer.append("cccfoo => cccbar cccbaz");
//        	writer.newLine();
//        	writer.append("pixima => pixma");        	
//        	writer.newLine();
//        	writer.append("fooaaa,baraaa,bazaaa");
//        	writer.newLine();
//        	writer.append("GB,gib,gigabyte,gigabytes");
//        	writer.newLine(); 
//        	writer.append("MB,mib,megabyte,megabytes");
//        	writer.newLine(); 
//        	writer.append("Television,Televisions,TV,TVs");
//        	writer.newLine(); 
        	writer.append("长沙,长沙市");
        	writer.newLine();        	
        	writer.append("深圳,深圳市,鹏城");
        	writer.newLine(); 
        	writer.append("南京,南京市,金陵");
        	writer.flush();        	
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
