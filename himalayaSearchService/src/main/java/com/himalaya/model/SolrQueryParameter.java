package com.himalaya.model;

public class SolrQueryParameter {
	
	private String queryCondition;
	private int start;
	private int rows;
	private String sort;
	private String filterQuery;
	private String filedList;
	
	public String getQueryCondition() {
		return queryCondition;
	}
	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getFilterQuery() {
		return filterQuery;
	}
	public void setFilterQuery(String filterQuery) {
		this.filterQuery = filterQuery;
	}	
	public String getFiledList() {
		return filedList;
	}
	public void setFiledList(String filedList) {
		this.filedList = filedList;
	}	
}
