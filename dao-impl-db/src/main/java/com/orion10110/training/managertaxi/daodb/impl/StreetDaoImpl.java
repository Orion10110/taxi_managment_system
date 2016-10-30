package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.training.managertaxi.daodb.StreetDao;

@Repository
public class StreetDaoImpl extends GenericDaoImpl<Street,Long> implements StreetDao {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, Street entity) throws SQLException {
		ps.setString(1, entity.getName());
		ps.setLong(2, entity.getIdDistrict());
	}

	@Override
	protected List<Object> setParamsForUpdate(Street entity) {
		ArrayList<Object> list= new ArrayList<Object>();
		list.add(entity.getName());
		list.add(entity.getIdDistrict());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return "insert into street (name,id_district) values(?,?)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update street set name = ?, id_district = ? where id = ?";
	}

	@Override
	protected String getTable() {
		return "street";
	}

	

}
