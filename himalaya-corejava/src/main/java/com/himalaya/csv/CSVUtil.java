package com.himalaya.csv;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年10月18日 上午10:59:21
* Description
*/
public class CSVUtil {

	public static void read(String filePath){

        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);

            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // 读一整行
                System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                //System.out.println(csvReader.get("Link"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writeHeader(String filePath){

        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // 写表头
            String[] headers = {"ID","NAME","AGE"};
            csvWriter.writeRecord(headers);
            String[] content = {"12365","zhang san","34"};
            csvWriter.writeRecord(content);
            String[] content1 = {"12345","li si","35"};
            csvWriter.writeRecord(content1);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writeRecord(String filePath){

        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            String[] content = {"12365","张山","34"};
            csvWriter.writeRecord(content, true);
            String[] content1 = {"12345","李鬼","35"};
            csvWriter.writeRecord(content1, true);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void appendRecord(String filePath){

		BufferedWriter writer = null;
        try {
        	writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,true)));
        	writer.append("1111,fred,32");
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
	
	public static void main(String[] args) {

        String filePath = "d:/test.csv";
        
        writeHeader(filePath);
        appendRecord(filePath);
        
        System.out.println("-----------------------");
        read(filePath);
	}
}
