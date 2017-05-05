package com.himalaya.solr.client;

import java.util.List;

import com.himalaya.model.AddressDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月5日 下午3:26:30
* Description
*/
public interface IndexClient {

	public void addDocuments(List<AddressDO> docs);
	
	public void updateDocument(List<AddressDO> docs);
	
	public void removeDocumentById(int id);
	
	public void removeAllDocuments();
}
