package com.himalaya.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IOUtils {

	public static String getRelatedFilePath(String filePath){
		
		System.out.println(filePath);
		
		URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
		
		String path = null;
		
		try {
			// if the path is in Chinese characters
			path = URLDecoder.decode(url.getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("url : " + path);
		return path;
	}
	
	public static List<StockInfo> readStockInfo(String file){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<StockInfo> stockInfos = new ArrayList<StockInfo>();
		File f = new File(file);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String lineStr = null;
			while((lineStr=br.readLine())!=null){
				String[] infos = lineStr.split(" ");
				stockInfos.add(new StockInfo(Float.parseFloat(infos[0]), sdf.parse(infos[1])));
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stockInfos;
	}
	
	public static void main(String[] args) throws Exception{
		
		String configPath = "config/config.xml";
		
		System.out.println(getRelatedFilePath(configPath));
		
		configPath = "config/股票信息.txt";
		
		System.out.println(getRelatedFilePath(configPath));
		
		List<StockInfo> stockInfos = readStockInfo(getRelatedFilePath(configPath));
		
		StockInfo[] array = new StockInfo[stockInfos.size()];
		stockInfos.toArray(array);
		
		print(stockInfos);
		System.out.println();
		sort(stockInfos);
		print(stockInfos);
	}
	
	public static void print(List<StockInfo> stockInfos){
		for (StockInfo stockInfo : stockInfos) {
			System.out.println(stockInfo);
		}
	}
	public static void sort(List<StockInfo> list){
		StockInfo temp = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < list.size()-i; j++) {
				if(list.get(j-1).getDate().compareTo(list.get(j).getDate())>0){
					temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, temp);
				}
			}
		}
	}
}

class StockInfo{
	
	float price;
	Date date;
	
	public StockInfo(float price, Date date) {
		super();
		this.price = price;
		this.date = date;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date) + " " + price;
	}
}
