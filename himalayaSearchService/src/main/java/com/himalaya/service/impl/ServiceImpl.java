package com.himalaya.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import com.himalaya.model.SolrQueryParameter;
import com.himalaya.service.IService;
import com.himalaya.util.Constants;

@Service
public class ServiceImpl implements IService {

	private final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

	@Autowired
	private HttpSolrClient httpSolrClient;

	/**
	 * query tags by rank
	 */
	public String queryTags(String keyWords, int rows, int currentPage) throws Exception {

		SolrClient solr = new HttpSolrClient("http://localhost:8080/solr/solr");

		SolrQueryParameter params = new SolrQueryParameter();
		params.setQueryCondition("tag_name:\"" + keyWords + "\"" );
		params.setStart(currentPage * rows);
		params.setRows(rows);
		params.setFiledList(Constants.SOLR_PARAMS_FIELD_LIST);
		params.setFilterQuery(Constants.SOLR_PARAMS_FILTERQUERY);
		params.setSort(Constants.SOLR_PARAMS_SORT_FIELD + " " + SolrQuery.ORDER.desc);
		return query(params);
	}

	/**
	 * query hot tags
	 */
	public String queryHotestTags(String keyWords, int rows, int currentPage) throws Exception {

		// get from redis
		// if not exists in redis, then search from solr
		SolrQueryParameter params = new SolrQueryParameter();
		params.setQueryCondition(keyWords);
		params.setStart(currentPage*rows);
		params.setRows(rows);
		params.setFiledList(Constants.SOLR_PARAMS_FIELD_LIST);
		params.setFilterQuery(Constants.SOLR_PARAMS_FILTERQUERY);
		params.setSort(Constants.SOLR_PARAMS_SORT_FIELD + " " + SolrQuery.ORDER.desc);
		return query(params);
	}

	private String query(SolrQueryParameter params) throws Exception {
		JSONArray tags = new JSONArray();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("q", params.getQueryCondition());
			map.put("fl", params.getFiledList());
			map.put("fq", params.getFilterQuery());
			map.put("start", String.valueOf(params.getStart()));
			map.put("rows", String.valueOf(params.getRows()));
			map.put("sort", params.getSort());
			map.put("wt", Constants.SOLR_PARAMS_WT);
			
			logger.info("Query string : " + getQueryString(map));
			
			SolrParams solrParams = new MapSolrParams(map);
			QueryResponse resp = httpSolrClient.query(solrParams);

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
