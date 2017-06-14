package com.himalaya.service.client;

import org.junit.Test;

import com.himalaya.service.IService;

public class ServiceClientTest {
	
	/**
	@Test
	public void getSetUser() {
		System.out.println("--------------------------------");
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IService.class);
		factory.setAddress("http://localhost:8090/himalayaWebService/services/searchService");
		IService service = (IService) factory.create();
		System.out.println("invoke webservice..."); 
		service.setUser();
		System.out.println("invoke webservice...");
	}*/
	
	@Test
	public void testService1(){
		IServiceService serviceStub = new IServiceService();
		System.out.println("invoke webservice..."); 
		IService service = serviceStub.getIServicePort();
		//service.service("FredXu");
		System.out.println("invoke webservice...");				
	}
	
	@Test
	public void testService2(){
		try {
			IServiceService serviceStub = new IServiceService();
			System.out.println("invoke webservice..."); 
			IService service = serviceStub.getIServicePort();
			service.service("{username:'FredXu',id:121}");
			System.out.println("invoke webservice...");
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParseUser(){
		try {
			IServiceService serviceStub = new IServiceService();
			System.out.println("invoke webservice..."); 
			IService service = serviceStub.getIServicePort();
			User user = new User();
			user.setUserId("12");
			user.setUserName("Fred Xu");
			String result = service.parseUser(user);
			
			System.out.println(result);
			System.out.println("invoke webservice...");
			
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	@Test
	public void postSetUser() {

		try {
			System.out.println("--------------------------------");
			
			String urlString = "http://localhost:8090/himalayaWebService/services/searchService/setUser";

			System.out.println("invoke webservice...");
			HttpPost httpPost = new HttpPost(urlString); //
		    DefaultHttpClient client = new DefaultHttpClient(); //
		    client.execute(httpPost);
			System.out.println("invoke webservice...");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetUserGet() {

		try {
			System.out.println("--------------------------------");
			
			String urlString = "http://localhost:8090/himalayaWebService/services/searchService/setUser";

			System.out.println("invoke webservice...");
			HttpGet httpGet = new HttpGet(urlString); //
			DefaultHttpClient client = new DefaultHttpClient(); //
		    client.execute(httpGet);
			System.out.println("invoke webservice...");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testService() {

		try {

			System.out.println("--------------------------------");

			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

			factory.setServiceClass(IService.class);

			factory.setAddress("http://localhost:8090/himalayaWebService/services/searchService");

			IService client = (IService) factory.create();

			String response = client.service("Fred");

			System.out.println("Response:" + response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
