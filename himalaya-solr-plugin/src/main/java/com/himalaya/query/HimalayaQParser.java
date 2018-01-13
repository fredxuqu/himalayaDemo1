package com.himalaya.query;

import org.apache.lucene.search.Query;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.search.QParser;
import org.apache.solr.search.SyntaxError;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年11月11日 下午3:45:29
* Description
*/
public class HimalayaQParser extends QParser {

	public HimalayaQParser(String qstr, SolrParams localParams, SolrParams params, SolrQueryRequest req) {
		super(qstr, localParams, params, req);
	}

	@Override
	public Query parse() throws SyntaxError {
		return null;
	}
}