package com.himalaya.controller;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.himalaya.BaseTestCase;

public class ControllerTest extends BaseTestCase {

//	@Autowired
//	@Qualifier("controller")
//	private SearchController controller;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddDocument() {
	}

	@Test
	public void testGetTags() {
		final String uri = "http://localhost:8080/solrService/search/tags?keyWords='����'&currentPage=0&rows=10";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String result = restTemplate.getForObject(uri, String.class);

		System.out.println("^&^&^& " + result);
	}
	
	@Test
	public void testGetHotestTags() {
		final String uri = "http://localhost:8080/solrService/search/hotTags";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String result = restTemplate.getForObject(uri, String.class);

		System.out.println("^&^&^& " + result);
	}

	/**
	@Test
	public void testGetProductsHttpClient() {
		final String url = "http://localhost:8080/solrService/search/product/*";

		try {
			HttpClient httpClient = new DefaultHttpClient();

			HttpGet getRequest = new HttpGet(url);

			getRequest.setHeader(new BasicHeader("Accept", "application/json"));

			HttpResponse response = httpClient.execute(getRequest);

			HttpEntity entity = response.getEntity();

			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println("^&^&^& " + entity.getContent());

			Product[] products = mapper.readValue(entity.getContent(), Product[].class);

			System.out.println("^&^&^& " + products.length);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
