package com.himalaya.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.himalaya.model.User;

@WebService
public interface IService {
	
	@WebMethod
    public String service(@WebParam(name = "username") String username)throws Exception;  
	
	@WebMethod
    public String parseUser(@WebParam(name = "user") User user)throws Exception;  
	
	@WebMethod
    public void setUser();
}
