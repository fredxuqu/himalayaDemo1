package com.himalaya.httpclient;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class OkHttpClientDemo {

	private static final String REQUEST_URL = "http://localhost:8080/springmvc/login?username=fred&pwd=123456";
	OkHttpClient client = new OkHttpClient();

	String run(String url) throws IOException {
	  Request request = new Request.Builder().url(url).build();

	  Response response = client.newCall(request).execute();
	  return response.body().string();
	}
	
	public static void main(String[] args) {
		OkHttpClientDemo demo = new OkHttpClientDemo();
		try {
			String result = demo.run(REQUEST_URL);
			System.out.println("Result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
