package com.himalaya.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.core.SolrDeletionPolicy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConvertSpecialChar {
	
	SolrDeletionPolicy a;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}	
	
	private String convert(String input){
		//StringBuilder result = new StringBuilder();
		// StringBuilder is thread safe.
		StringBuffer result = new StringBuffer();
		String regex = "[+\\-&|!(){}\\[\\]^\"~*?:(\\)]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			matcher.appendReplacement(result, "\\\\"+matcher.group());
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	@Test
	public void testConvert(){
		String input="a+b-c&d&e&&f|g!h(i)j{k}l[m]n^o\"o ~p*q?r:s\\";
		System.out.println(convert(input));
	}
}
