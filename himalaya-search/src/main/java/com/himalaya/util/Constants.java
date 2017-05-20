package com.himalaya.util;

public class Constants {
	public static final String SOLR_PARAMS_DEFAULT_FIELD_LIST="id, tagName";
	public static final String SOLR_PARAMS_FILTERQUERY="type:1";
	public static final String SOLR_PARAMS_FILTERQUERY_GEO="{!geofilt}&sfield=location_rpt&pt=";
	public static final String SOLR_PARAMS_SORT_FIELD="rank";
	public static final String SOLR_PARAMS_WT="json";
}
