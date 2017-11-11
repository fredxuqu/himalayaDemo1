package com.himalaya.query;

import org.apache.solr.common.params.SolrParams;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.search.QParser;
import org.apache.solr.search.QParserPlugin;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年11月11日 下午3:44:07
* Description
*/
public class HimalyaQParsePlugin extends QParserPlugin {

	@Override
	public QParser createParser(String qstr, SolrParams localParams, SolrParams params, SolrQueryRequest req) {
		return null;
	}
}
