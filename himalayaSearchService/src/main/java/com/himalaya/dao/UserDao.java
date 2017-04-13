package com.himalaya.dao;

import java.util.List;

import com.himalaya.model.UserDO;


public interface UserDao {
	
	List<UserDO>listAll();
	
	int countByCondition();
}
