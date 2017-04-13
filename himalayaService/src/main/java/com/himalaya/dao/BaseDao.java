package com.himalaya.dao;

import java.sql.SQLException;

public interface BaseDao<T> {
	
	int insert(String statement, T entity) throws SQLException;
	void delete(String statement, int primaryKey) throws SQLException;
	int update(String statement, T entity) throws SQLException;
	T get(String statement, int primaryKey) throws SQLException;
}
