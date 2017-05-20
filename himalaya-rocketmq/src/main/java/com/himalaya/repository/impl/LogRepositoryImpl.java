package com.himalaya.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.himalaya.model.LogInfo;
import com.himalaya.repository.LogRepository;

@Repository
public class LogRepositoryImpl implements LogRepository{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends LogInfo> void insert(List<S> log) {
		for (S s : log) {
			mongoTemplate.insert(s);
		}		
	}

	@Override
	public LogInfo findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogInfo> findAll() {
		return mongoTemplate.find(new Query(), LogInfo.class);
	}

	@Override
	public List<LogInfo> findByRegex(String regex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOne(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAndModify(String id) {
		// TODO Auto-generated method stub
		
	}

}
