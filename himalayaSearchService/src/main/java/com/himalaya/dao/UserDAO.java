package com.himalaya.dao;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月3日 上午11:17:22
* Description
*/
import java.util.List;

import com.himalaya.model.UserDO;

public interface UserDAO {
	
	List<UserDO> listAll();
	
	int countByCondition();
}
