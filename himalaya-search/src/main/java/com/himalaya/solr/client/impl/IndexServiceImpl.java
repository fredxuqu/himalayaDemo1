package com.himalaya.solr.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.himalaya.model.AddressDO;
import com.himalaya.solr.client.IndexClient;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月5日 下午3:26:49
* Description
*/
@Service
public class IndexServiceImpl implements IndexClient {

	@Override
	public void addDocuments(List<AddressDO> docs) {
		
		List<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();  
        for (int i = 0; i < 10; i++) {  
        	
            SolrInputDocument doc = new SolrInputDocument();  
            doc.addField("id", i);  
            doc.addField("severity",i);  
            doc.addField("sLocation","Beijing_" + i);  
            doc.addField("msg", "kobe bryant" + i);  
            doc.addField("name", "kylin soong" + i);  
            solrDocs.add(doc);
        }  		
	}

	@Override
	public void updateDocument(List<AddressDO> docs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDocumentById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllDocuments() {
		// TODO Auto-generated method stub
		
	}

}
