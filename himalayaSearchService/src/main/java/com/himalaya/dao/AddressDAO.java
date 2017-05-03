package com.himalaya.dao;

import java.util.List;

import com.himalaya.model.AddressDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月3日 上午11:39:55
* Description
*/
public interface AddressDAO {
	
	List<AddressDO> getAddressByPage(int start, int end);
}
