package com.himalaya.dao;

import java.util.List;

public interface NewsDAO<T> {
	
	List<T> list() throws Exception;
}
