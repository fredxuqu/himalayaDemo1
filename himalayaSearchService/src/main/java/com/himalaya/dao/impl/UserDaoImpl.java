package com.himalaya.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.himalaya.dao.UserDao;
import com.himalaya.model.UserDO;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

	private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private final String SQL_QUERY_ALL = "SELECT * FROM TB_USERS ";
	private final String SQL_COUNT = "SELECT COUNT(*) FROM TB_USERS ";
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<UserDO> listAll() {
		
		logger.debug("SQL : " + SQL_QUERY_ALL);
		List<UserDO> users = namedParameterJdbcTemplate.query(SQL_QUERY_ALL, new RowMapper<UserDO>() {
			
			@Override
			public UserDO mapRow(ResultSet rs, int arg1) throws SQLException {
				UserDO user = new UserDO();
				user.setId(rs.getInt("ID"));
				user.setUserName(rs.getString("USER_NAME"));
				return user;
			}
		});
		
		logger.info("Found {} users!",users.size());
		return users;
	}
	
	public int countByCondition() {
		
		return 0;
	}
}
