package com.himalaya.dao;

import java.util.List;

public interface ForumDao<T>{
	
	List<T> getForumListByPage() throws Exception;
	List<T> getForumList() throws Exception;
}
