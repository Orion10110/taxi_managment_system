package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.TypeCarDao;

@Repository
public class TypeCarDaoImpl extends GenericDaoImpl<TypeCar, Long>{

	@Override
	protected void setParamsForInsert(PreparedStatement ps, TypeCar entity) throws SQLException {
		ps.setString(1, entity.getType());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(TypeCar entity) {
		ArrayList<Object> params= new ArrayList<Object>();
		params.add(entity.getType());
		return params;
	}

	@Override
	protected String getTable() {
		return "type_car";
	}

	@Override
	protected String getSqlSelectList() {
		return "select * from type_car";
	}

	@Override
	protected String getSqlInsert() {
		return "insert into type_car (type) values(?)";
	}

	@Override
	protected String getSqlUpdate() {
	
		return "update type_car set type = ? where id = ?";
	}

	

}
