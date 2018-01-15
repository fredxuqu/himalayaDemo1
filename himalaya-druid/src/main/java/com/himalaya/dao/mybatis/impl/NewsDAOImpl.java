package com.himalaya.dao.mybatis.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himalaya.dao.NewsDAO;
import com.himalaya.model.NewsDO;

@Repository
public class NewsDAOImpl implements NewsDAO<NewsDO>{
	
	private SqlSessionTemplate sessionTemplate;
	
    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}
	
	@Override
	public List<NewsDO> list() throws Exception {
		return this.getSessionTemplate().selectList("NewsDao.list");
	}
}
