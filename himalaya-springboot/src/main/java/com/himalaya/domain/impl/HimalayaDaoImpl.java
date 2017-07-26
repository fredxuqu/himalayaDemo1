package com.himalaya.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.himalaya.domain.HimalayaDao;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年7月26日 上午11:00:51 Description
 */
@Repository
public class HimalayaDaoImpl implements HimalayaDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int count() {

		return jdbcTemplate.queryForObject("select 1 from dual", Integer.class);
	}
}
