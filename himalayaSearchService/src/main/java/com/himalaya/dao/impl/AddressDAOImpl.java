package com.himalaya.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.himalaya.dao.AddressDAO;
import com.himalaya.model.AddressDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年5月3日 上午11:42:17
* Description
*/
@Repository
public class AddressDAOImpl implements AddressDAO{

	private final Logger logger = LoggerFactory.getLogger(AddressDAOImpl.class);
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private final String SQL_QUERY = "SELECT * " + 
									   "FROM (SELECT ROWNUM AS rowno, t.* " + 
										       "FROM TB_ADDRESS_INFO t " + 
										      "WHERE ROWNUM <= ?) tmp " + 
									  "WHERE tmp.rowno >= ? ";
	
	@Override
	public List<AddressDO> getAddressByPage(int start, int end) {
		logger.debug("SQL : " + SQL_QUERY);
		
		Object[] params = new Object[]{end, start};
		int[] types = new int[]{Types.INTEGER, Types.INTEGER};
				
		List<AddressDO> addressList = jdbcTemplate.query(SQL_QUERY, params, types, new RowMapper<AddressDO>() {
			
			@Override
			public AddressDO mapRow(ResultSet rs, int arg1) throws SQLException {
				AddressDO address = new AddressDO();
				address.setId(rs.getInt("ID"));
				address.setProvinceName(rs.getString("PROVINCE_NAME"));
				address.setProvinceCode(rs.getString("PROVINCE_CODE"));
				address.setCityCode(rs.getString("CITY_CODE"));
				address.setCityName(rs.getString("CITY_NAME"));
				address.setCountyCode(rs.getString("COUNTY_CODE"));
				address.setCountyName(rs.getString("COUNTY_NAME"));
				address.setLatitude(rs.getFloat("LATITUDE"));
				address.setLongitude(rs.getFloat("LONGITUDE"));
				address.setAddress(rs.getString("ADDRESS"));
				return address;
			}
		});
		
		logger.info("Found {} address!",addressList.size());
		return addressList;
	}
}
