package com.himalaya.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Paging{
	
	private final static Logger logger = LoggerFactory.getLogger(Paging.class);
	
	private int pageSize;
	private int pageNo;
	private int startRow;
	private int endRow;
	
	public Paging(int pageNo, int pageSize){
		if(pageNo<=0){
			logger.error("pageNo should be more than 01");
			throw new RuntimeException("pageNo should be more than 01");
		}
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startRow = pageNo-1 * pageSize;
		this.endRow = pageNo * pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}

