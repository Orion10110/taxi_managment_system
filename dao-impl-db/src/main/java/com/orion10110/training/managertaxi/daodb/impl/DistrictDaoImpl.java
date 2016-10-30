package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.daodb.DistrictDao;

@Repository
public class DistrictDaoImpl extends GenericDaoImpl<District,Long> implements DistrictDao {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, District entity) throws SQLException {
		ps.setString(1, entity.getName());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(District entity) {
		ArrayList list =new ArrayList();
		list.add(entity.getName());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return  "insert into district (name) values(?)";
	}

	@Override
	protected String getSqlUpdate() {
		
		return "update district set name = ? where id = ?";
	}

	@Override
	protected String getTable() {
		return "district";
	}

	
	

}
