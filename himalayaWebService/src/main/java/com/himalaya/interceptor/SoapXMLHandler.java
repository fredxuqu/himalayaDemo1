package com.himalaya.interceptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.xpath.DefaultXPath;

public class SoapXMLHandler {
	
	private static final String DEFAULTXPATH = "//return";
	
	private static final String SINGLETONMAP_KEY = "ns1";
	
	private static final String SINGLETONMAP_VALUE = "http://service.himalaya.com/";
	
	public static String getSoapBodyXml(Message message) {

		String xmlStr = null;
		CachedStream cs = null;
		try {
			OutputStream os = message.getContent(OutputStream.class);
			System.out.println("os.hashCode() = " + os.hashCode());
			cs = new CachedStream();
			message.setContent(OutputStream.class, cs);
			message.getInterceptorChain().doIntercept(message);
			CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
			InputStream in = csnew.getInputStream();
			xmlStr = IOUtils.toString(in, "UTF-8");
			IOUtils.copy(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")), os);
			os.flush();
			cs.close();			
			message.setContent(OutputStream.class, os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return xmlStr;
	}

	public static String getSoapResult(String soapXml) throws Exception {
		Document doc = DocumentHelper.parseText(soapXml);
		DefaultXPath xpath = new DefaultXPath(DEFAULTXPATH);
		xpath.setNamespaceURIs(Collections.singletonMap(SINGLETONMAP_KEY, SINGLETONMAP_VALUE));

		StringBuilder returnVal = new StringBuilder();
		List list = xpath.selectNodes(doc);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Element node = (Element) iterator.next();
			returnVal.append(node.getText());
		}
		return returnVal.toString();
	}
}

class CachedStream extends CachedOutputStream { 
	
    public CachedStream() { 
        super();  
    } 

    protected void doFlush() throws IOException { 
        currentStream.flush();  
    } 

    protected void doClose() throws IOException {  
    } 

    protected void onWrite() throws IOException { 
    }
}
