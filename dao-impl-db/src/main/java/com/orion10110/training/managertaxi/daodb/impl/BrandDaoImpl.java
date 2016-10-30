package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.BrandDao;


@Repository
public class BrandDaoImpl extends GenericDaoImpl<Brand,Long> implements BrandDao  {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, Brand entity) throws SQLException {
		ps.setString(1, entity.getName());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(Brand entity) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(entity.getName());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return "insert into brand (name) values(?)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update brand set name=? where id=?";
	}

	@Override
	protected String getTable() {
		return "brand";
	}

	

}
