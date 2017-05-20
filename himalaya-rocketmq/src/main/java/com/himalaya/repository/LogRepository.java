package com.himalaya.repository;

import java.util.List;

import com.himalaya.model.LogInfo;

public interface LogRepository{
	public <S extends LogInfo> void insert(List<S> log);   
    
    public LogInfo findOne(String id);     
    
    public List<LogInfo> findAll();     
      
    public List<LogInfo> findByRegex(String regex);  
    
    public void removeOne(String id);     
      
    public void removeAll();     
      
    public void findAndModify(String id); 
}
