package com.himalaya.solr.client;

public interface QueryClient {
	
	public String queryTags(String keywords, int rows, int pageNo)throws Exception;
	
	public String queryHotestTags(String keywords, int rows, int pageNo)throws Exception;
	
	public String queryMultiCollections(String keywords, int rows, int pageNo)throws Exception;
}
