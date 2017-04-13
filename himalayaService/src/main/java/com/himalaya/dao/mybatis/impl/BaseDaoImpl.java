package com.himalaya.dao.mybatis.impl;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{

	private SqlSessionTemplate sessionTemplate;
	
    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	@Override
	public int insert(String statement, T entity) throws SQLException {
		return sessionTemplate.insert("ForumMyBatisDao.insert", entity);
	}

	@Override
	public void delete(String statement, int primaryKey) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(String statement, T entity) throws SQLException {
		// TODO Auto-generated method stub
		return sessionTemplate.update("ForumMyBatisDao.update", entity);
	}

	@Override
	public T get(String statement, int primaryKey) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
