package com.himalaya.service;

public interface IService {
	
	public String queryTags(String keywords, int rows, int pageNo)throws Exception;
	
	public String queryHotestTags(String keywords, int rows, int pageNo)throws Exception;
	
//	public void addDocument();
//	
//	public void addDocumentPerPage();
//	
//	public void updateDocument();
//	
//	public void removeAllDocuments();

}
