package com.himalaya.dao.mybatis.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.himalaya.dao.ForumDao;
import com.himalaya.model.ForumDO;

@Repository
public class ForumMyBatisDaoImpl extends BaseDaoImpl<ForumDO> implements ForumDao<ForumDO>{

	@Override
	public List<ForumDO> getForumListByPage() throws Exception {
		return null;
	}

	@Override
	public List<ForumDO> getForumList() throws Exception {
		
		return this.getSessionTemplate().selectList("ForumMyBatisDao.listAll");
	}
}
