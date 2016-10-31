package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.TypeCarDao;

@Repository
public class TypeCarDaoImpl extends GenericDaoImpl<TypeCar,Long> implements TypeCarDao{


	@Override
	protected String getTable() {
		return "type_car";
	}


	@Override
	protected String getSqlInsert() {
		return "insert into type_car (type) values(:type)";
	}

	@Override
	protected String getSqlUpdate() {
	
		return "update type_car set type = :type where id = :id";
	}

	

}
