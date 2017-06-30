package com.himalaya.solr.client.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himalaya.solr.client.QueryClient;
import com.himalaya.util.Constants;

@Service
public class QueryServiceImpl implements QueryClient {

	private final Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

	@Autowired
	private HttpSolrClient httpSolrClient;

	/**
	 * query tags by rank
	 */
	public String queryTags(String keyWords, int rows, int currentPage) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("collection", "tags");
		if(StringUtils.isEmpty(keyWords)){
			map.put("q", "*:*" );
		}else{
			map.put("q", "tagName:\"" + keyWords + "\"" );
		}
		map.put("fl", Constants.SOLR_PARAMS_DEFAULT_FIELD_LIST);
		map.put("fq", Constants.SOLR_PARAMS_FILTERQUERY);
		map.put("start", String.valueOf(currentPage * rows));
		map.put("rows", String.valueOf(rows));
		map.put("sort", Constants.SOLR_PARAMS_SORT_FIELD + " " + SolrQuery.ORDER.desc);
		map.put("wt", Constants.SOLR_PARAMS_WT);
		
		return query(map);
	}

	/**
	 * query hot tags
	 */
	public String queryHotestTags(String keyWords, int rows, int currentPage) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("collection", "tags");
		if(StringUtils.isEmpty(keyWords)){
			map.put("q", "*:*" );
		}else{
			map.put("q", "tagName:\"" + keyWords + "\"" );
		}
		map.put("fl", "id, tagName");
		map.put("fq", Constants.SOLR_PARAMS_FILTERQUERY);
		map.put("start", String.valueOf(currentPage * rows));
		map.put("rows", String.valueOf(rows));
		map.put("sort", Constants.SOLR_PARAMS_SORT_FIELD + " " + SolrQuery.ORDER.desc);
		map.put("wt", Constants.SOLR_PARAMS_WT);
		
		return query(map);
	}
	
	/**
	 * query hot tags
	 */
	public String queryByPosition(String keyWords, String position, int rows, int currentPage) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("collection", "address");
		if(StringUtils.isEmpty(keyWords)){
			map.put("q", "*:*" );
		}else{
			map.put("q", "detailAddress:\"" + keyWords + "\"" );
		}		
		map.put("fl", "id, detailAddress, position");	// field list
		map.put("fq", "{!geofilt}");		// distance compute function
		map.put("pt", position);			// pointer
		map.put("sfield", "position_rpt"); 	// spatial field
		map.put("d", String.valueOf(5));	// max distance between target position and result position
		map.put("sort", "geodist() asc");	// sorting by distance ascending
//		http://localhost:8983/solr/address/select?q=*:*&fq={!geofilt}&sfield=position_rpt&pt=121.8950%2056.156&d=100&sort=geodist()%20asc&wt=json&indent=on
		map.put("wt", Constants.SOLR_PARAMS_WT);
		
		return query(map);
	}
	
	@Override
	public String queryMultiCollections(String keywords, int rows, int pageNo) throws Exception {
		return null;
	}

	private String query(Map<String, String> map) throws Exception {
		JSONArray tags = new JSONArray();
		try {
			
			logger.info("Query string : " + getQueryString(map));
			
			SolrParams solrParams = new MapSolrParams(map);
			QueryResponse resp = httpSolrClient.query(map.get("collection"), solrParams);

			SolrDocumentList docsList = resp.getResults();
			logger.info("Result Size : {}", docsList.size());
			for (SolrDocument doc : docsList) {
				tags.put(doc);
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return tags.toString();
	}
	
	private String getQueryString(Map<String, String> params){
		
		Set<String> keySets = params.keySet();
		StringBuffer queryString = new StringBuffer();
		queryString.append("q").append("=").append(params.get("q"));
		for (String key : keySets) {
			if(!"q".equals(key)){
				queryString.append("&").append(key).append("=").append(params.get(key));
			}
		}
		return queryString.toString();
	}
}
