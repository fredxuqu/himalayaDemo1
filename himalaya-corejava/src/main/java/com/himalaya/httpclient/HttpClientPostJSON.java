package com.himalaya.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年10月26日 下午7:17:44
* Description
*/
public class HttpClientPostJSON {

	//post请求方法
    public static String sendPost(String url, String data) {
        String response = null;

        try { 
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "utf-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils
                       .toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
       } catch (Exception e) {
            e.printStackTrace();
       }
       return response;
    }
    
    public static void main(String[] args) {
    	
    	// corp getlist
    	String url = "http://localhost:8080/himalaya/test";
    	String response = HttpClientPostJSON.sendPost(url, null);
    	System.out.println(response);
		
    	// corp getlist
    	url = "http://localhost:8080/himalaya/corp/getlist?";
    	StringBuffer data = new StringBuffer("{");
    	data.append("\"querystr\":\"华为\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// address getlist
    	url = "http://localhost:8080/himalaya/address/getlist?";
    	data = new StringBuffer("{");
    	data.append("\"area\":\"深圳市福田区\",");
    	data.append("\"querystr\":\"平安科技大厦\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// 企业名称校验
    	url = "http://localhost:8080/himalaya/corp/verify?";
    	data = new StringBuffer("{");
    	data.append("\"querystr\":\"华为技术\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// 地址校验
    	url = "http://localhost:8080/himalaya/address/verify?";
    	data = new StringBuffer("{");
    	data.append("\"selectedaddress\":\"深圳市福田区\",");
    	data.append("\"detailaddress\":\"平安科技大厦\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// 企业名称比对
    	url = "http://localhost:8080/himalaya/compare/get?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"1\",");
    	data.append("\"item1\":\"华为技术\",");
    	data.append("\"item2\":\"华为技术有限公司\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// 地址比对
    	url = "http://localhost:8080/himalaya/compare/get?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"1\",");
    	data.append("\"item1\":\"深圳市福田区平安科技大厦\",");
    	data.append("\"item2\":\"广东省深圳市福田区平安科技大厦\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println(response);
    	
    	// 名称规范化
    	url = "http://localhost:8080/himalaya/normalize/get?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"1\",");
    	data.append("\"querystr\":\"华为技术有限公司\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println("corp normalize : " + response);
    	
    	// 地址规范化
    	url = "http://localhost:8080/himalaya/normalize/get?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"2\",");
    	data.append("\"querystr\":\"南山区腾讯科技大厦\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println("addr normalize : " + response);
    	
    	// 比对反馈
    	url = "http://api-stg2.tianxiaxinyong.com/pycreditnlp/compare/feedback?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"2\",");
    	data.append("\"item1\":\"深圳市福田区\",");
    	data.append("\"item2\":\"深圳市福田区\",");
    	data.append("\"result\":\"dfasfasdfds\",");
    	data.append("\"feedbacks\":\"sdfasfdafsdfas\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println("compare feedback" + response);
    	
    	// host
    	url = "http://api-stg2.tianxiaxinyong.com/pycreditnlp/verify/feedback?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"1\",");
    	data.append("\"querystr\":\"华为技术\",");
    	data.append("\"selectedaddress\":\"\",");
    	data.append("\"detailaddress\":\"\",");
    	data.append("\"result\":\"\",");
    	data.append("\"feedbacks\":\"verify feedback\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println("verify feedback : " + response);
    	
    	
    	// host
    	url = "http://api-stg2.tianxiaxinyong.com/pycreditnlp/normalize/feedback?";
    	data = new StringBuffer("{");
    	data.append("\"mode\":\"1\",");
    	data.append("\"querystr\":\"华为技术\",");
    	data.append("\"reliability\":\"\",");
    	data.append("\"docs\":\"\",");
    	data.append("\"normalizeditem\":\"华为技术\",");
    	data.append("\"feedbacks\":\"normalized feedback\"");
    	data.append("}");
    	response = HttpClientPostJSON.sendPost(url, data.toString());
    	System.out.println("normalize feedback : " + response);
	}
}