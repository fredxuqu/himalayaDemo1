package com.himalaya.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.xpath.DefaultXPath;

public class TestDom { 

	/**
	 	<?xml version="1.0" encoding="UTF-8"?>
		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		   <soap:Header />
		   <soap:Body>
		      <ns1:GetPersonal_jh1Response xmlns:ns1="http://bank.services.applications.dykj.com">
		         <ns1:out>
		            <ns1:string>LTE=</ns1:string>
		            <ns1:string>sumyu7W9uPbIy7v5sb7Qxc+i</ns1:string>
		         </ns1:out>
		      </ns1:GetPersonal_jh1Response>
		   </soap:Body>
		</soap:Envelope>
	 */
	public static void main(String[] args) {
		String a = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" "+
			    "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "+
			    "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
			    "<soap:Header/><soap:Body><ns1:GetPersonal_jh1Response xmlns:ns1=\"http://bank.services.applications.dykj.com\">" +
			    "<ns1:out>"
			    +"<ns1:string>LTE=</ns1:string>"
			    +"<ns1:string>sumyu7W9uPbIy7v5sb7Qxc+i</ns1:string>"
			    +"</ns1:out>"
			    +"</ns1:GetPersonal_jh1Response></soap:Body></soap:Envelope>";
		System.out.println(a);
		String b = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> " + " <soap:Body>"
				+ " <ns2:serviceResponse xmlns:ns2=\"http://service.himalaya.com/\">"
				+ "  <ns2:return>Hello {username:'fred',id:1}</ns2:return>" + " </ns2:serviceResponse>" + " </soap:Body>"
				+ "</soap:Envelope>";
		try {
			Document doc = DocumentHelper.parseText(b);
			DefaultXPath xpath = new DefaultXPath("//ns1:return");
			xpath.setNamespaceURIs(Collections.singletonMap("ns1", "http://service.himalaya.com/"));

			List list = xpath.selectNodes(doc);
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				Element node = (Element) iterator.next();
				System.out.println(node.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}